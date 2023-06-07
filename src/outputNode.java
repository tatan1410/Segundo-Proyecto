public class outputNode {
    private String nombre_completo, curso, cedula;  
    private String[][] fullMateria;


    public outputNode(String nombre_completo, String curso, String cedula, Float[][] notas, String[] materia, int n_materias) {
        fullMateria  = new String[n_materias][6];
        this.nombre_completo = nombre_completo;
        this.curso = curso;
        this.cedula = cedula;
        

        for (int i = 0; i < n_materias; i++) {
            fullMateria[i][0] = materia[i];
            fullMateria[i][1] = String.format("%f", promedio(notas[i]));
            for (int j = 0; j < notas[i].length; j++) {
                if(notas[i][j] == null) {
                    this.fullMateria[i][j+2] = "asd";
                } else {
                    this.fullMateria[i][j+2] = notas[i][j].toString();
                }
            }
        }

    }
    public outputNode(String nombre_completo, String curso, String cedula) {
        this.nombre_completo = nombre_completo;
        this.curso = curso;
        this.cedula = cedula;
    }

    public float promedio(Float[] vec) {
        float contador=0;

        for (int i = 0; i < vec.length; i++) {
            contador+=vec[i];
        }

        return contador/4;
    }
    
    // getters and setters
    public String getNombre_completo() {
        return nombre_completo;
    }
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String[][] getfullMateria() {
        return fullMateria;
    }
    public void setfullMateria(String[][] fullMateria) {
        this.fullMateria = fullMateria;
    }
}
