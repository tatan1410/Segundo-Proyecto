import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        StudentList estudiantes = new StudentList();
        // Estudiantes de prueba
        estudiantes.add_student("Sebastian", "Castaño", "Informatica", "123");
        estudiantes.search_student("123").add_materia("math");
        estudiantes.search_student("123").update_grade(1, 2, "math");
        estudiantes.search_student("123").update_grade(2, 5, "math");
        estudiantes.search_student("123").update_grade(3, 3, "math");
        estudiantes.search_student("123").update_grade(4, Float.parseFloat("3.3"), "math");

        estudiantes.search_student("123").add_materia("algoritmos");
        estudiantes.search_student("123").update_grade(2, 2, "algoritmos");
        estudiantes.search_student("123").update_grade(4, Float.parseFloat("3.3"), "algoritmos");

        estudiantes.add_student("Orlando", "Correa", "Player", "1234");
        estudiantes.search_student("1234").add_materia("math");
        estudiantes.search_student("1234").update_grade(4, Float.parseFloat("3.3"), "math");

        while (true) {
            try {

                switch (menu()) {
                    case 1: // Añadir estudiante.
                        String cc = joption("Cedula estudiante:", true);
                        estudiantes.add_student(joption("Nombre estudiante:", true),
                                joption("Apellido estudiante:", true), joption("Carrera estudiante:", true), cc);

                        estudiantes.search_student(cc).add_materia(joption("Materia por defecto.", true));
                        break;
                    case 2: // mostrar estudiantes.
                        int opc = Integer.parseInt(joption(
                                "Mostrar estudiante en especifico\n1. Estudiantes especifico.\n2.Todos.", true));
                        if (1 == opc) {
                            joption(mostrar_estudiante_completo(estudiantes, joption("Cedula", true)), false);
                        } else if (2 == opc) {
                            joption(mostrar_estudiantes(estudiantes), false);
                        } else
                            joption("Opcion invalida.", false);

                        break;
                    case 3: // Añadir Materia.
                        estudiantes.search_student(joption("Cedula", true))
                                .add_materia(joption("Nombre de la materia", true));
                        break;

                    case 4: // Editar notas.
                        estudiantes.search_student(joption("Cedula", true)).update_grade(
                                Integer.parseInt(joption("Numero de nota: ", true)),
                                Float.parseFloat(joption("Nueva nota: ", true)),
                                joption("Materia: ", true));
                        break;

                    case 5: // salir
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Select an option.");
                        break;

                }

            } catch (Exception e) {

            }
        }
    }

    public static int menu() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Añadir estudiante.\n" +
                "2. Mostrar estudiantes.\n" +
                "3. Añadir materia.\n" +
                "4. Editar notas.\n" +
                "5. Salir.\n"
        ));
    }

    public static String mostrar_estudiantes(StudentList estudiantes) {
        OutputNode[] est = estudiantes.showAllStudents();
        String s = "";
        for (int i = 0; i < est.length; i++) {
            s += "Nombre: " + est[i].getNombre_completo() +
                    "\nCedula: " + est[i].getCedula() +
                    "\nCarrera: " + est[i].getCurso() +
                    "\n[" + "=".repeat((est[i].getNombre_completo().length() * 3 / 2)) + "]\n";
        }
        return s;
    }

    public static String mostrar_estudiante_completo(StudentList estudiantes, String cc) {
        OutputNode est = estudiantes.showStudent(cc);

        if (est == null) {
            return "Estudiante No Encontrado";
        }

        String notas = "";
        for (int j = 0; j < est.getfullMateria().length; j++) {
            notas += "\n\t" + est.getfullMateria()[j][0] + ": \n\t\tPromedio: " + est.getfullMateria()[j][1];

            for (int k = 2; k < est.getfullMateria()[j].length; k++) {
                notas += "\n\t\tNota " + (k - 1) + " : " + est.getfullMateria()[j][k];
            }
        }
        String s = "Nombre: " + est.getNombre_completo() +
                "\nCedula: " + est.getCedula() +
                "\nCarrera: " + est.getCurso() +
                "\nNotas: " + notas;
        return s;
    }

    public static String joption(String s, boolean input) {
        if (!input) {
            JOptionPane.showMessageDialog(null, s);
            return "";
        }
        return JOptionPane.showInputDialog(s);
    }
}
