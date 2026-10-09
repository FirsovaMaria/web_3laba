package web_3laba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Web_3laba {

    static Scanner sc = new Scanner(System.in, "UTF-8");

    static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Пустая строка. Повторите.");
        }
    }

    static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().replace(',', '.');
            try {
                double v = Double.parseDouble(s);
                if (v <= 0) {
                    System.out.println("Должно быть > 0.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }
    }

    static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v <= 0) {
                    System.out.println("Должно быть > 0.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    //Ввод номера из списка
    static int readIndex(String prompt, int size) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int idx = Integer.parseInt(s);
                if (idx < 1 || idx > size) {
                    System.out.printf("Введите число от 1 до %d.%n", size);
                    continue;
                }
                return idx - 1;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    //Печать списка с номерами
    static void printNumbered(River[] rivers) {
        for (int i = 0; i < rivers.length; i++) {
            System.out.printf("  %d) %s (%.1f км)%n",
                    i + 1, rivers[i].getName(), rivers[i].getLength());
        }
    }

    public static void main(String[] args) {

        int n = readPositiveInt("Сколько рек ввести? ");
        River[] rivers = new River[n];

        //Ввод
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Река #" + (i + 1) + " ---");
            String name = readString("Название: ");
            double length = readPositiveDouble("Длина (км): ");
            double width = readPositiveDouble("Ширина (м): ");
            double depth = readPositiveDouble("Глубина (м): ");
            double velocity = readPositiveDouble("Скорость (м/с): ");

            rivers[i] = new River(name, length, width, depth, velocity);
            System.out.println("Добавлено.");
        }

        //Самая короткая
        River min = rivers[0];
        for (River r : rivers) if (r.getLength() < min.getLength()) min = r;
        System.out.println("\n1) Самая короткая река:");
        System.out.println(min.info());

        //Длиннее средней
        double sum = 0;
        for (River r : rivers) sum += r.getLength();
        double avg = sum / n;
        System.out.printf("%n2) Средняя длина = %.1f км. Длиннее:%n", avg);
        boolean any = false;
        for (River r : rivers) {
            if (r.getLength() > avg) {
                System.out.println(r.info());
                any = true;
            }
        }
        if (!any) System.out.println("  (нет таких)");

        //По алфавиту
        Arrays.sort(rivers, Comparator.comparing(River::getName));
        System.out.println("\n3) По алфавиту:");
        for (River r : rivers) System.out.println(r.info());

        // Редактирование по номеру
        System.out.println("\n4) Редактирование — выберите реку по номеру:");
        printNumbered(rivers);

        int idx = readIndex("Номер: ", rivers.length);
        River found = rivers[idx];

        System.out.println("\nВыбрана река:");
        System.out.println(found.info());

        double newLength = readPositiveDouble("\nНовая длина (км): ");
        found.setLength(newLength);

        System.out.println("\nПосле редактирования:");
        System.out.println(found.info());

        sc.close();
    }
}