import Delivery.BasketImpl;
import Store.MeatStore;
import Store.MeatStoreImpl;
import model.Beef;
import model.Chicken;
import model.Meat;
import model.Pork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private static char currentLetter = 'A';
    private static int currentNumber = 1;
    public static void main(String[] args) {
        MeatStore meatStore = new MeatStoreImpl();
        BasketImpl basket = new BasketImpl(meatStore);
        System.out.println(""" 
                Приветствуем вас в оптовом онлайн магазине 'В гостях у Лектора' г.Борзя
                у нас всегда только свежее мясо выращенное на собственных фермах",
                """);
        shift(meatStore, basket);
    }
    private static void shift(MeatStore meatStore, BasketImpl basket) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String select = "1";
            while (true) {
                System.out.println("""       
                         1. Наша продукция
                         2. Оформление заказа
                         3. Посмотреть корзину
                         4. Выйти из онлайн магазина
                        """);
                select = br.readLine();
                switch (select) {
                    case "1":
                        meatStore.displayInventory();
                        System.out.println(""" 
                                1. Добавить товары в корзину
                                2. В главное меню
                                """);
                        String i = br.readLine();
                        if (i.equals("1")) {
                            System.out.print("Введите название:");
                            String type = br.readLine();
                            System.out.print("Введите количество кг.:");
                            int weight = Integer.parseInt(br.readLine());
                            Meat selectedMeat = null;
                            switch (type.toLowerCase()) {
                                case "beef":
                                    selectedMeat = new Beef("БМК", 600.0, 1, 4.0);
                                    break;
                                case "pork":
                                    selectedMeat = new Pork("Мираторг", 400.0, 1, 4.5);
                                    break;
                                case "chicken":
                                    selectedMeat = new Chicken("Приосколье", 350.0, 1, 3.0);
                                    break;
                                default:
                                    System.out.println("Неверно указан вид мяса");
                            }
                            if (selectedMeat != null) {
                                basket.addMeatToBasket(selectedMeat, weight);
                                basket.displayBasket();
                                meatStore.displayInventory();
                            }
                        } else {
                            break;
                        }
                        break;
                    case "2":
                        System.out.println("""
                               Оформление заказа:
                               Текущая корзина:
                               """);
                        System.out.println("Подтвердите заказ (yes/no):");
                        String confirmOrder = br.readLine();
                        if (confirmOrder.equalsIgnoreCase("yes")) {
                            System.out.print("Сумма заказа составляет:" );
                            int sum = 0;
                            for (Meat meat : basket.getBasket().keySet()) {
                                sum += (int) ( meat.getPrice()*basket.getBasket().get(meat));
                                }
                            System.out.println(sum);
                            System.out.println("Ваш заказ оформлен. Номер заказа: " + generateOrderNumber());
                            basket.getBasket().clear();
                            System.out.println("Ваш заказ успешно оформлен. Корзина очищена.");
                        } else {
                            System.out.println("Заказ не был подтвержден. Продолжайте покупки.");
                        }
                        break;
                    case "3":
                        basket.displayBasket();
                        System.out.println(""" 
                                1. Удалить товары из корзины
                                2. В главное меню
                                """);
                        String choice = br.readLine();
                        if (choice.equals("1")) {
                            System.out.print("Введите название товара для удаления: ");
                            String toRemove = br.readLine();
                            Meat meatToRemove = null;
                            for (Meat meat : basket.getBasket().keySet()) {
                                if (toRemove.equalsIgnoreCase(meat.getView().toString())) {
                                    meatToRemove = meat;
                                    break;
                                }
                            }
                            if (!toRemove.isEmpty()) {
                                System.out.print("Введите количество кг для удаления: ");
                                int quantityToRemove = Integer.parseInt(br.readLine());
                                int currentQuantityInBasket = basket.getBasket().getOrDefault(meatToRemove, 0);
                                if (currentQuantityInBasket >= quantityToRemove) {
                                    basket.removeMeatFromBasket(meatToRemove, quantityToRemove);
                                    System.out.println("Товар успешно удален из корзины и возвращен на склад.");
                                    basket.displayBasket();
                                    meatStore.displayInventory();
                                } else {
                                    System.out.println("В корзине недостаточно указанного количества товара для удаления.");
                                }
                            } else {
                                System.out.println("Товар с указанным названием не найден в корзине.");
                            }
                        } else {
                            break;
                        }
                        break;
                    case "4":
                        System.exit(0);
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateOrderNumber() {
        String orderNumber = currentLetter + String.format("%03d", currentNumber);
        if (currentNumber < 999) {
            currentNumber++;
        } else {
            currentNumber = 1;
            currentLetter++;
            if (currentLetter > 'Z') {
                currentLetter = 'A';
            }
        }
        return orderNumber;
    }
}





