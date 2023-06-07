public class StudentList extends Exception {
    private StudentNode start = null;

    public OutputNode[] showAllStudents() { // returns a string with the list
        StudentNode p = start;

        OutputNode[] vec = new OutputNode[this.size()];
        int i = 0;
        
        while (p != null) {
            vec[i] = new OutputNode(p.getNombre()+" "+p.getApellido(),p.getCarrera(),p.getCedula());
            i++;
            p = p.getNextStudent();
        }
        
        return vec;
    }

    public OutputNode showStudent(String cc) {
        StudentNode p = search_student(cc);
        if (p==null) return null;

        Float a[][] = new Float[p.getMaterias().getNombreMaterias().length][4];
        String[] nombre_materias;
        nombre_materias = new String[p.getMaterias().getNombreMaterias().length];

        for(int j = 0; j<p.getMaterias().getNombreMaterias().length; j++) { // iterar en todas la devuletas
            nombre_materias[j] = p.getMaterias().getNombreMaterias()[j];
            a[j] = p.getMaterias().getPilasNotas()[j].mostrar(); // a = las notas de la pila en posicion j
        }
        return new OutputNode(p.getNombre()+" "+p.getApellido(),p.getCarrera(),p.getCedula(), a, nombre_materias ,p.getMaterias().getNombreMaterias().length);
    }

    public void add_student(String nombre, String apellido, String carrera, String cedula) {
        if( isEmpty() ) {
            start = new StudentNode(nombre, apellido, carrera, cedula);
        } else {
            StudentNode p = start;
            while(p.getNextStudent() != null) {
                p = p.getNextStudent();
            }
            p.setNextStudent(new StudentNode(nombre, apellido, carrera, cedula));
        }
    }


    public StudentNode search_student(String cc) {
        StudentNode p = start;
        while(p != null) {
            if (p.getCedula().equals(cc)) {
                break;
            }
            p = p.getNextStudent();
        }
        return p;
    }

    // >--------------[ UTILITY ]--------------<

    public boolean isEmpty() { // return true if the list is empty
        return start == null ? true : false;
    }

    public int size() { //return the number of nodes of the list
        StudentNode p = start;
        int counter = 0;
        while (p != null) {
            p = p.getNextStudent();
            counter++;
        }
        return counter;
    }

}
