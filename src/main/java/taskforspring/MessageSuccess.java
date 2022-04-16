package taskforspring;

public enum MessageSuccess {

    SAVE_SUCCESS("Успешное сохранение сущности в БД"),
    UPDATE_SUCCESS("Успешное обновление сущности в БД"),
    DELETE_SUCCESS("Успешное удаление сущности из БД");

    MessageSuccess(String message) {}
}
