import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;
import static java.util.Calendar.*;
import static java.util.Calendar.SECOND;

public class Platos {
    private ArrayBlockingQueue<Integer> platosSucios = new ArrayBlockingQueue<>(20);
    private ArrayBlockingQueue<Integer> platosMojados = new ArrayBlockingQueue<>(20);
    private ArrayBlockingQueue<Integer> platosSecos = new ArrayBlockingQueue<>(20);
    private ArrayBlockingQueue<Integer> alacena = new ArrayBlockingQueue<>(20);
    Calendar now = getInstance();
    public Platos() {
        for (int i = 0; i < 20; i++) {
            platosSucios.add(i);
        }
    }
    public int cogerSucio() throws InterruptedException {
        Integer plato = platosSucios.take();
        System.out.printf("%d:%d:%d - %s: cogido el plato sucio #%d\n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        return plato;
    }
    public void ponerMojados(Integer plato) throws InterruptedException {
        System.out.printf("%d:%d:%d - %s: puesto el plato mojado #%d \n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        platosMojados.put(plato);
    }
    public int cogerMojados() throws InterruptedException {
        Integer plato = platosMojados.take();
        System.out.printf("%d:%d:%d - %s: cogido el plato mojado #%d\n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        return plato;
    }
    public int cogerSeco() throws InterruptedException {
        Integer plato = platosSecos.take();
        System.out.printf("%d:%d:%d - %s: cogido el plato seco #%d\n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        return plato;
    }
    public void ponerSeco(Integer plato) throws InterruptedException {
        System.out.printf("%d:%d:%d - %s: puesto el plato seco #%d \n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        platosSecos.put(plato);
    }
    public void organizar(Integer plato) throws InterruptedException {
        System.out.printf("%d:%d:%d - %s: organizado el plato #%d \n", now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND), Thread.currentThread().getName(), plato);
        platosSecos.put(plato);
    }

}
