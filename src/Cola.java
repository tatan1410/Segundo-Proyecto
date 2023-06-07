public class Cola {
    private ColaNodo punta;

    public Cola() {
        punta = null;
    }

    public void add_materia(String materia) {
        encolar(new ColaNodo(materia));
    }

    public void update_materia() {

    }

    public String[] getNombreMaterias() {
        String[] nombres = new String[size()];
        int c = 0;
        ColaNodo aux = null; 
        for(int i = 0; i<size(); i++) {
            aux = desencolar();
            nombres[c] = aux.getMateria();
            c++;
            encolar(aux);
        }
        return nombres;
    }
    
    public Pila[] getPilasNotas() {
        Pila[] pilas = new Pila[size()];
        int c = 0;
        ColaNodo aux = null; 
        for(int i = 0; i<size(); i++) {
            aux = desencolar();
            pilas[c] = aux.getPila();
            c++;
            encolar(aux);
        }
        
        return pilas;
    }

    public ColaNodo search_materia(String name) {
        ColaNodo p = null;
        ColaNodo aux = null;
        for(int i = 0; i<size(); i++) {
            aux = desencolar();
            if(aux.getMateria().equals(name)) p = aux;
            encolar(aux);
        }
        return p;
    }

    public ColaNodo desencolar() {
        ColaNodo p = punta;
        punta = punta.getNextColaNodo();
        p.setNextColaNodo(null);
        return p;
    }

    public void encolar(ColaNodo n) {
        if ( isEmpty() ){
            punta = n;
            return;
        }

        ColaNodo p = punta;
        while(p.getNextColaNodo() != null) {
            p = p.getNextColaNodo();
        }
        p.setNextColaNodo(n);
    }

    public boolean isEmpty() {
        return punta == null;
    }

    public int size() {
        int c = 0;
        ColaNodo p = punta;
        while(p != null) {
            c++;
            p = p.getNextColaNodo();
        }
        return c;
    }

    // getter and setters

    public ColaNodo[] getColaNodosNotas() {
        ColaNodo p = punta;
        ColaNodo ColaNodos[] = new ColaNodo[size()];
        int i = 0;
        while (p != null) {
            ColaNodos[i] = p;
            i++;
            p = p.getNextColaNodo();
        }

        return ColaNodos;
    }

    public ColaNodo getPunta() {
        return punta;
    }
    public void setPunta(ColaNodo punta) {
        this.punta = punta;
    }
}
