package myapps.datamodel;

public class CategoriaRifiuto extends CategoriaRifiutoBase {
    private final CategoriaRifiutoBase base;

    public CategoriaRifiuto(String name, ResultContainer currentAnalisi, CategoriaRifiutoBase base){
        super(name, currentAnalisi);
        this.base = base;
    }

    @Override
    public void updatePesoTotale(double delta){
        super.updatePesoTotale(delta);
        base.updatePesoTotale(delta);
    }
}
