package myapps.analisibioscav.datamodel;

public class CategoriaRifiuto extends CategoriaRifiutoBase {
    private final CategoriaRifiutoBase base;

    public CategoriaRifiuto(String name, ResultContainer resultContainer, CategoriaRifiutoBase base){
        super(name, resultContainer);
        this.base = base;
    }

    @Override
    public void updatePesoTotale(double delta){
        super.updatePesoTotale(delta);
        base.updatePesoTotale(delta);
    }
}
