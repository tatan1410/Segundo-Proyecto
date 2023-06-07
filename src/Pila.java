import java.util.Arrays;

public class Pila {
    private int limite, tope;
    private Float vec[];
    
    // contructor
    public Pila() {
        this.limite=4;
        this.tope=-1;
        vec = new Float[limite];
        Arrays.fill(vec, null);
        
        // crear el espacio para las 4 notas
        for (int i = 0; i < limite; i++) this.apilar(0);
    }

    public Pila(boolean a) {
        this.limite=4;
        this.tope=-1;
        vec = new Float[limite];
    }

    public void update_grade(int index, float newGrade) { // Actualizar
        Pila aux = new Pila(true);
        
        for (int i = 0; i < index; i++) {
            aux.apilar(this.desapilar());
        }

        aux.desapilar();
        this.apilar(newGrade);

        for (int i = 0; i < index-1; i++) {
            apilar(aux.desapilar());
        }
    }

    // Metodos Principales
    public Float[] mostrar() {
        // Se usa un array de objetos Float para usar null como diferenciador entre 0 y 0 real
        Float[] a = new Float[limite];
        Arrays.fill(a, null);

        Pila pilaAux = new Pila(true);
        float aux = 0;
        while (!pilaVacia()){
            pilaAux.apilar(this.desapilar());
        }
        pilaAux.invertir();
        int i = 0;
        while(!pilaAux.pilaVacia()) {
            aux = pilaAux.desapilar();
            this.apilar(aux);
            a[i] = aux;
            i++;
        }
        return a; 
    }
    
    public void vaciar() {
        while(!pilaVacia()) {
            desapilar();
        }
    }

    public void apilar(float d) { // apilar(n)
        tope++;
        vec[tope] = d;
    }

    public float desapilar(){
		float aux = vec[tope];
		tope--;
		return aux;
	}


    public void invertir () {
        Pila aux1 = new Pila(true);
        Pila aux2 = new Pila(true);

        while(!pilaVacia()) {
            aux1.apilar(this.desapilar());
        }
        while(!aux1.pilaVacia()) {
            aux2.apilar(aux1.desapilar());
        }

        while(!aux2.pilaVacia()) {
            this.apilar(aux2.desapilar());
        }
    }

    public void pasar(Pila P){
        while(!P.pilaLlena()) {
            this.apilar(P.desapilar());
        }
    }

    // Utilidad
    public boolean pilaLlena() {
        return tope == limite-1 ? true : false;
    }
    public boolean pilaVacia() {
        return tope == -1 ? true : false;
    }

    // Getters and Setters
    public int getLimite() {
        return limite;
    }
    public int getTope() {
        return tope;
    }
    public void setTope(int tope) {
        this.tope = tope;
    }    
}
