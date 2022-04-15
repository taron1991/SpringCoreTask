package services;

public interface CRUD {

    private void getStatistic() {
        System.out.println("Дарова");
    }

    default void sendToKafka() throws Exception {
        getStatistic();
    }
}
