public class ColaNodo {
    private ColaNodo nextColaNodo;
    private Pila pila;
    private String materia;

    //constructor
    public ColaNodo(String materia) {
        this.materia = materia;
        nextColaNodo = null;
        pila = new Pila();
    }

    public void update_grade(int index, float newGrade) {
        pila.update_grade(index, newGrade);
    }

    public Float[] getNotas() {
        return pila.mostrar();
    }

    public ColaNodo getNextColaNodo() {
        return nextColaNodo;
    }
    public void setNextColaNodo(ColaNodo nextColaNode) {
        this.nextColaNodo = nextColaNode;
    }
    public Pila getPila() {
        return pila;
    }
    public void setPila(Pila pila) {
        this.pila = pila;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
}
