package myapps.analisibioscav.datamodel;

public class AnalisiDAO {

    private InputContainer inputContainer = new InputContainer();
    private ResultContainer resultContainer = new ResultContainer();
    private AnagrafeAnalisi anagrafeAnalisi = new AnagrafeAnalisi();
    
    public AnalisiDAO(){
        inputContainer.setResultContainer(resultContainer);
    }

    public ResultContainer getResultContainer() {
        return resultContainer;
    }

    public InputContainer getInputContainer() {
        return inputContainer;
    }

    public AnagrafeAnalisi getAnagrafeAnalisi() {
        return anagrafeAnalisi;
    }

}
