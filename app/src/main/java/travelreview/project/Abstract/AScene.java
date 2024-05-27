package travelreview.project.Abstract;

import javafx.stage.Stage;

public abstract class AScene {
    public Stage stage;

    public AScene(Stage stage) {
        this.stage = stage;
    }

    protected abstract void show();
    protected abstract void show(int id);
    protected abstract void show(int id, int tempatWisataId);
}
