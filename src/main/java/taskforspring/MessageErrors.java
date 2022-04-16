package taskforspring;

public enum MessageErrors {
    SAVE_ERROR("Произошла ошибка при добавлении сущности в БД"),
    UPDATE_ERROR("Произошла ошибка при обновлении сущности в БД"),
    DELETE_ERROR("Произошла ошибка при удалении сущности в БД");

    MessageErrors(String message) {}
}
