package view;



import model.AbstractAnimal;

public interface View {
    /**
     * Команды главного меню
     */
    enum MainMenuCommand {
        ADD_ANIMAL (" Добавить новое животное"),
        SHOW_SKILLS(" Список команд животного (добавление новой)"),
        REMOVE_ANIMAL (" Выписка животного"),
        LIST_ANIMALS (" Общий список животных"),
        EXIT (" Выход");

        private final String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Команды меню обучения командам
     */
    enum AddSkillMenuCommand {
        ADD_SKILL (" Обучить новой команде"),
        EXIT (" Выход в главное меню");

        private String tag;

        AddSkillMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Показывает список животных в питомнике
     */
    void showKennelRegistry();

    /**
     * Показывает основное меню приложения
     * @return Возвращает выбранную команду
     */
    MainMenuCommand showMainMenuWithResult();

    /**
     * Показывает диалог добавления животного
     * @return Возвращает true в при успешном добавлении, false - в противном случае
     */
    boolean showAddAnimalDialog();

    /**
     * Показывает диалог выписки животного из питомника
     * @return Возвращает id выписанного животного или -1 при ошибке
     */
    int showRemoveAnimalDialog();

    /**
     * Показывает диалог отображения детальной информации о животном
     */
    void showDetailInfoAnimalDialog();

    /**
     * Показывает детальную информацию о животном
     */
    void showAnimalInfo(AbstractAnimal animal);

    /**
     * Показывает меню добавления команды
     * @return Возвращает выбранную команду
     */
    AddSkillMenuCommand showAddSkillMenu(AbstractAnimal animal);

    /**
     * Показывает диалог добавления навыка
     * @return Возвращает true в при успешном добавлении, false - в противном случае
     */
    boolean showAddSkillDialog(AbstractAnimal animal);
}
