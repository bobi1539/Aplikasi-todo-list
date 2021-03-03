import java.util.Scanner;

public class AppTodoList {

  public static String[] model = new String[10];
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    viewShowTodoList();
  }

  /**
   * membuat fungsi input
   * @param info isikan info
   * @return mengembalikan nilai berupa string
   */
  public static String input(String info){
    System.out.print(info + " : ");
    var data = scanner.nextLine();
    return data;
  }

  public static void testInput(){
    var name = input("nama anda");
    System.out.println(name);

    var channel = input("channel anda");
    System.out.println(channel);
  }

  /**
   * menampilkan dan test show todo list
   */
  public static void showTodoList(){
    System.out.println("\nTODO LIST");
    for (var i = 0; i < model.length; i++){

      var todo = model[i];
      var no = i + 1;

      if(todo != null){
        System.out.println(no + ". " + todo);
      }

    }
  }

  public static void testShowTodoList(){
    model[0] = "Belajar java";
    model[1] = "Belajar Python";
    showTodoList();
    input("Pilih");
  }

  /**
   * menampilkan view todo list
   */
  public static void viewShowTodoList(){
    while (true){

      showTodoList();
      System.out.println("MENU");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      var input = input("Pilih");
      if (input.equals("1")){
        //tambah todo list
        viewAddTodoList();
      } else if (input.equals("2")) {
        // hapus todo list
        viewRemoveTodoList();
      } else if (input.equals("x")) {
        // keluar
        break;
      } else {
        System.out.println("Pilihan tidak dimengerti");
      }
    }
  }


  /**
   * membuat view dan menambah, test add, test view add todo ke list
   */
  public static void viewAddTodoList(){
    System.out.println("Menambah TODOLIST");
    var todo = input("Todo (x jika batal)");

    if (todo.equals("x")){
      //batal
    } else {
      addTodoList(todo);
    }

  }

  public static void addTodoList(String todo){
    // cek jika model penuh
    var isFull = true;
    for (var i = 0; i < model.length; i++){
      if (model[i] == null){
        isFull = false;
        break;
      }
    }

    // jika penuh kita resize ukuran array 2x lipat
    if (isFull){
      var temp = model;
      model = new String[model.length * 2];
      for (var i = 0; i < temp.length; i++){
        model[i] = temp[i];
      }
    }

    // menambahkan todo ke model

    for (var i = 0; i < model.length; i++){
      if (model[i] == null){
        model[i] = todo;
        break;
      }
    }

  }

  public static void testViewAddTodoList(){
    addTodoList("satu");
    addTodoList("dua");

    viewAddTodoList();

    showTodoList();
  }

  public static void testAddTodoList(){
    for (var i = 0; i < 25; i++){
      addTodoList("contoh ke " + i);
    }
    showTodoList();
  }

  /**
   * membuat view dan mengapus, test remove, test view remove todo list
   */
  public static void viewRemoveTodoList(){
    System.out.println("Hapus TODO List");

    var noRemove = input("Masukan Nomor yang ingin dihapus (x jika batal)");
    if (noRemove.equals("x")){
      //batal
    } else {
      boolean success = removeTodoList(Integer.valueOf(noRemove));
      if (!success){
        System.out.println("Gagal menghapus todo list no : " + noRemove);
      }
    }

  }

  public static boolean removeTodoList(Integer number){
    if ((number - 1) >= model.length){
      return false;
    } else if (model[number - 1] == null){
      return false;
    } else {
      for (var i = (number - 1); i < model.length; i++){
        if (i == (model.length - 1)){
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }
      return true;
    }
  }

  public static void testRemoveTodoList(){
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");
    addTodoList("empat");
    addTodoList("lima");

    var result = removeTodoList(20);
    System.out.println(result);

    result = removeTodoList(8);
    System.out.println(result);

    result = removeTodoList(5);
    System.out.println(result);
    showTodoList();


  }

  public static void testViewRemoveTodoList(){
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");

    showTodoList();
    viewRemoveTodoList();
    showTodoList();
  }

}
