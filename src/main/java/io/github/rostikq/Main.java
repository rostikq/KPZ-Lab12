package io.github.rostikq;


import io.github.rostikq.logger.Logger;
import io.github.rostikq.task02.*;
import io.github.rostikq.task01.ShipmentMarker;
import io.github.rostikq.task01.ShipmentType;
import io.github.rostikq.task01.ShipmentTypeFactory;
import io.github.rostikq.task03.CargoComponent;
import io.github.rostikq.task03.CargoGroup;
import io.github.rostikq.task03.SingleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ РІШЕНЬ ДЛЯ ВАРІАНТУ 3 («ПОСИЛКА+») ===\n");

        runTask1();
        System.out.println("\n---------------------------------------------------\n");
        runTask2();
        System.out.println("\n---------------------------------------------------\n");
        runTask3();
    }

    public static void runTask1() {
        System.out.println("--- ЗАВДАННЯ 1: Відстеження відправлень на мапі (Flyweight) ---");

        // Створюємо масив із 5 можливих типів відправлень
        String[] typeNames = {"Звичайне", "Крихке", "Холодове", "Документи", "Негабаритне"};
        String[] icons = {"box.png", "fragile.png", "cold.png", "doc.png", "large.png"};
        String[] colors = {"Blue", "Orange", "Cyan", "Green", "Red"};

        List<ShipmentMarker> markers = new ArrayList<>();
        Random random = new Random();

        // Формуємо мапу з 20 000 відправлень випадкових типів
        for (int i = 1; i <= 20000; i++) {
            int typeIndex = random.nextInt(typeNames.length);
            ShipmentType type = ShipmentTypeFactory.getType(
                    typeNames[typeIndex], icons[typeIndex], colors[typeIndex]
            );

            markers.add(new ShipmentMarker(
                    "TN-" + (100000 + i),
                    48.3794 + random.nextDouble(),
                    25.9381 + random.nextDouble(),
                    "В дорозі",
                    type
            ));
        }

        Logger.log("Main", "Сформовано мапу з " + markers.size() + " відправлень.");
        System.out.println("Фактична кількість створених об'єктів позначок: " + markers.size());
        System.out.println("Фактична кількість створених об'єктів типів (Flyweight): " + ShipmentTypeFactory.getTypesCount());

        // Демонстрація посилання на той самий об'єкт типу
        System.out.println("\nПеревірка спільних об'єктів для двох позначок:");
        ShipmentMarker m1 = markers.get(0);
        ShipmentMarker m2 = markers.get(100);

        m1.printInfo();
        m2.printInfo();

        System.out.println("Чи посилаються на один і той самий об'єкт типу? " + (m1.getType() == m2.getType()));
    }

    public static void runTask2() {
        System.out.println("--- ЗАВДАННЯ 2: Сповіщення клієнтів (Bridge) ---");

        // 1. Надіслати сповіщення про прибуття через SMS і через e-mail
        Notification arrivalSms = new ArrivalNotification(new SmsChannel());
        arrivalSms.notifyClient("+380501112233");

        Notification arrivalEmail = new ArrivalNotification(new EmailChannel());
        arrivalEmail.notifyClient("client@gmail.com");

        // 2. Надіслати сповіщення про затримку через Viber
        Notification delayViber = new DelayNotification(new ViberChannel());
        delayViber.notifyClient("+380673334455");

        // 3. Додати канал Telegram одним класом і надіслати ним сповіщення про оплату
        Notification paymentTelegram = new PaymentNotification(new TelegramChannel());
        paymentTelegram.notifyClient("@client_telegram");
    }

    public static void runTask3() {
        System.out.println("--- ЗАВДАННЯ 3: Консолідація вантажу (Composite) ---");

        // Збираємо структуру: рейс -> палети -> мішки (у тому числі мішок у мішку) -> відправлення
        CargoGroup flight = new CargoGroup("Вантажний рейс #305");

        CargoGroup pallet1 = new CargoGroup("Палета #1");
        CargoGroup bag1 = new CargoGroup("Мішок великий #1");

        // Вкладений мішок у мішок (підтримується без змін у коді)
        CargoGroup innerBag = new CargoGroup("Внутрішній міні-мішок");
        innerBag.add(new SingleItem("Документи голуб", 0.5, 100.0));
        innerBag.add(new SingleItem("Крихка флешка", 0.2, 500.0));

        bag1.add(innerBag);
        bag1.add(new SingleItem("Коробка з взуттям", 1.5, 1200.0));

        pallet1.add(bag1);
        pallet1.add(new SingleItem("Побутова техніка", 12.0, 8500.0));

        CargoGroup pallet2 = new CargoGroup("Палета #2");
        pallet2.add(new SingleItem("Одяг (пакунок)", 4.0, 2000.0));

        flight.add(pallet1);
        flight.add(pallet2);

        // Вивести структуру деревом з вагою і вартістю кожного вузла
        System.out.println("\nСтруктура вантажу:");
        flight.printTree("");

        // Вивести показники для всього рейсу і для однієї палети тим самим викликом (методи спільного інтерфейсу)
        System.out.println("\n--- Результати виклику спільних методів ---");
        printNodeMetrics("Всьому рейсу", flight);
        printNodeMetrics("Палеті #1", pallet1);
    }

    private static void printNodeMetrics(String nodeName, CargoComponent component) {
        System.out.println("Показники для [" + nodeName + "]: Вага = " + component.getWeight() +
                " кг, Вартість = " + component.getDeclaredValue() +
                " грн, Кількість вкладень = " + component.getItemsCount());
    }
}