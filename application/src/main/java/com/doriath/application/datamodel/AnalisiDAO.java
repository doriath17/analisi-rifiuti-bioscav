package com.doriath.application.datamodel;

public class AnalisiDAO {

    private ResultContainer resultContainer = new ResultContainer();
    private InputContainer inputContainer = new InputContainer(resultContainer);
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
