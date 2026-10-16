package web_3laba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Web_3laba {

    static Scanner sc = new Scanner(System.in, "UTF-8");

    // ввод
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

    static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Введите число от %d до %d.%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("да")) return true;
            if (s.equals("нет")) return false;
            System.out.println("Введите «да» или «нет».");
        }
    }

    static River readRiver() {
        String name = readString("Название: ");
        double length = readPositiveDouble("Длина (км): ");
        double width = readPositiveDouble("Ширина (м): ");

        System.out.println("Тип реки: 1) Обычная  2) Горная  3) Приток");
        int type = readInt("Тип: ", 1, 3);

        switch (type) {
            case 2:
                double slope = readPositiveDouble("Уклон: ");
                int rapids = readInt("Количество порогов: ", 0, 1000);
                return new MountainRiver(name, length, width, slope, rapids);
            case 3:
                String main = readString("В какую реку впадает: ");
                boolean seasonal = readYesNo("Сезонный? (да/нет): ");
                return new Tributary(name, length, width, main, seasonal);
            default:
                return new River(name, length, width);
        }
    }

    //функции по заданию
    static River findShortest(River[] rivers) {
        River min = rivers[0];
        for (River r : rivers) {
            if (r.getLength() < min.getLength()) min = r;
        }
        return min;
    }

    static void printShortest(River[] rivers) {
        System.out.println("\n1) Самая короткая река:");
        System.out.println(findShortest(rivers).info());
    }

    static void printLongerThanAverage(River[] rivers) {
        double sum = 0;
        for (River r : rivers) sum += r.getLength();
        double avg = sum / rivers.length;

        System.out.printf("%n2) Средняя длина = %.1f км. Реки длиннее средней:%n", avg);
        boolean any = false;
        for (River r : rivers) {
            if (r.getLength() > avg) {
                System.out.println(r.info());
                any = true;
            }
        }
        if (!any) System.out.println("  (нет таких)");
    }

    static void printSortedByName(River[] rivers) {
        Arrays.sort(rivers, Comparator.comparing(River::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("\n3) По алфавиту:");
        for (River r : rivers) System.out.println(r.info());
    }

    static River findByName(River[] rivers, String name) {
        for (River r : rivers) {
            if (r.getName().equalsIgnoreCase(name)) return r;
        }
        return null;
    }

    static void editRiver(River[] rivers) {
        String name = readString("\n4) Введите название реки для поиска: ");
        River found = findByName(rivers, name);
        if (found == null) {
            System.out.println("Река с таким названием не найдена.");
            return;
        }

        System.out.println("\nНайдена река:");
        System.out.println(found.info());

        System.out.println("\nЧто редактировать?");
        System.out.println("  1) Название");
        System.out.println("  2) Длина");
        System.out.println("  3) Ширина");
        switch (readInt("Поле: ", 1, 3)) {
            case 1:
                found.setName(readString("Новое название: "));
                break;
            case 2:
                found.setLength(readPositiveDouble("Новая длина (км): "));
                break;
            case 3:
                found.setWidth(readPositiveDouble("Новая ширина (м): "));
                break;
        }

        System.out.println("\nПосле редактирования:");
        System.out.println(found.info());
    }


    public static void main(String[] args) {
        System.out.println("Пискарева и Фирсова, 3 лаба, 5 вариант - реки");
        while (true) {
            int n = readInt("\nСколько рек ввести? (0 - выход): ", 0, 10);
            if (n == 0) break;

            River[] rivers = new River[n];
            for (int i = 0; i < n; i++) {
                System.out.println("\nРека №" + (i + 1));
                rivers[i] = readRiver();
            }

            printShortest(rivers);
            printLongerThanAverage(rivers);
            printSortedByName(rivers);
            editRiver(rivers);
        }
    }
}
