//Реализация многопоточной программы, которая добавляет в synchronizedMap элементы с ключами от 100 * THREAD_NUM до 100 * (THREAD_NUM + 1),
//где THREAD_NUM - номер потока.

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedMapExample {
    public static void main(String[] args) throws InterruptedException { //метод может выбросить исключение InterruptedException, которое возникает при прерывании потоков
        // Создаем синхронизированный map на основе TreeMap
        Map<Integer, String> syncMap = Collections.synchronizedMap(new TreeMap<>()); //защищита от конкурентного доступа и синхронизация

        int numThreads = 3; // Количество потоков

        ExecutorService executor = Executors.newFixedThreadPool(numThreads); //Создание пула потоков с фиксированным числом потоков

        for (int i = 0; i < numThreads; i++) {
            final int threadNum = i; //Номер текущего потока
            Runnable task = () -> {
                System.out.println("Поток " + threadNum + " начинает работу");
                for (int j = 100 * threadNum; j < 100 * (threadNum + 1); j++) {
                    syncMap.put(j, "Значение для ключа " + j);
                }
                System.out.println("Поток " + threadNum + " завершил работу");
            };
            executor.execute(task); //Задача передается пулу потоков для выполнения
        }

        executor.shutdown(); //Пул потоков закрывается после того, как все задачи завершены
        executor.awaitTermination(10, TimeUnit.SECONDS); //Ожидает завершения всех задач в течение 10 секунд. Если за это время задачи не завершатся, программа продолжит выполнение

        System.out.println("\nСодержимое карты:");
        syncMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}