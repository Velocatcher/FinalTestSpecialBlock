

import controler.KennelAccounting;
import model.AbstractAnimal;
import storage.KennelStorage;
import storage.Storage;
import view.ConsoleView;
import view.View;

public class App {
    /**
     * Основной цикл приложения, где происходит обработка основных команд
     * (добавить животное, показать команды животного, выписать из питомника, список животных)
     */
    public static void run() {
        KennelAccounting kennelAccounting = new KennelAccounting(new KennelStorage());
        View view = new ConsoleView(kennelAccounting);

        while (true) {

            View.MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> {
                    view.showDetailInfoAnimalDialog();
                }
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1  ? "Выписано животное " + removeId : "Не удалось  выписать животное";
                    System.out.println(resMessage);
                }
                case LIST_ANIMALS -> {
                    view.showKennelRegistry();
                }
                case EXIT -> {
                    System.out.println("Ждем Вас снова!");
                    return;
                }
            }
        }
    }
}