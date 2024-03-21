package ra.model;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singer {
    private int singerId = 1;
    private String singerName;
    private int age;
    private String singerNationality;
    private boolean singerGender;
    private String singerGenre;

    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String singerNationality, boolean singerGender, String singerGenre) {
        this.singerId = singerId++;
        this.singerName = singerName;
        this.age = age;
        this.singerNationality = singerNationality;
        this.singerGender = singerGender;
        this.singerGenre = singerGenre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSingerAge() {
        return age;
    }

    public void setSingerAge(int singerAge) {
        this.age = singerAge;
    }

    public String getSingerNationality() {
        return singerNationality;
    }

    public void setSingerNationality(String singerNationality) {
        this.singerNationality = singerNationality;
    }

    public boolean getSingerGender() {
        return singerGender;
    }

    public void setSingerGender(boolean singerGender) {
        this.singerGender = singerGender;
    }

    public String getSingerGenre() {
        return singerGenre;
    }

    public void setSingerGenre(String singerGenre) {
        this.singerGenre = singerGenre;
    }


    private boolean validate(String regex, String input) {
        //dung regex de validate
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private String getInputFromUser(Scanner scanner, String regex) {
        String data = scanner.nextLine();
        boolean isValidate = validate(regex, data);
        if (isValidate) {
            return data;
        } else {
            System.out.println("Du lieu ban nhap khong hop le,vui long nhap lai");
            return getInputFromUser(scanner, regex);
        }
    }


    private Singer[] singerArr = new Singer[100];

    Singer inputData(Scanner scanner) {
        System.out.println("Mời bạn nhập tên ca sĩ: ");
        String singerName = getInputFromUser(scanner, ".+");
        System.out.println("Mời bạn nhập tuổi ca sĩ: ");
        int singerAge = Integer.parseInt(getInputFromUser(scanner, "\\d{0,100}"));
        System.out.println("Mời bạn nhập quốc tịch của ca sĩ: ");
        String singerNationality = getInputFromUser(scanner, ".+");
        System.out.println("Mời bạn nhập giới tính ca sĩ: ");
        boolean singerGender = Boolean.parseBoolean(getInputFromUser(scanner, "^(true|false)$"));
        System.out.println("Mời bạn nhập thể loại nhạc: ");
        String singerGenre = getInputFromUser(scanner, ".+");
        return new Singer(singerId++, singerName, singerAge, singerNationality, singerGender, singerGenre);
    }

    public void addData(Scanner scanner) {
        System.out.println("Mời bạn nhập số lượng ca sĩ cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] == null) {
                singerArr[i] = inputData(scanner);
                number--;
            }
            if (number == 0) {
                break;
            }
        }
    }

    public void displayData() {
        System.out.printf("Mã ca sĩ: %d |", singerId);
        System.out.printf("Tên ca sĩ: %s |", singerName);
        System.out.printf("Tuổi: %d | \n", age);
        System.out.printf("quốc tich: %s |", singerNationality);
        System.out.printf("Mo ta: %s |", singerGenre);
        System.out.printf("giới tính: %s  \n", (singerGender ? "Nam" : "Nu"));

    }

    public void showData() {
        System.out.println("danh sach sinh vien hien tai \n");
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] != null) {
                singerArr[i].displayData();
            }

        }
    }

    public void updateSinger(Scanner scanner) {
        int id = song.escape();
        if (id == 0) {

            return;
        }
        int singerArrId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] != null && singerArr[i].getSingerId() == singerArrId) {
                singerArr[i] = inputData(scanner);
                break;
            }
            System.out.println("Không tìm thấy ca sĩ có id " + id + " để xóa.");
        }
    }

    Song song = new Song();

    public void deleteSinger(Scanner scanner) {
        int id = song.escape();
        if (id == 0) {

            return;
        }
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] != null && singerArr[i].getSingerId() == id) {
                singerArr[i] = null;
                System.out.println("Ca sĩ có id " + id + " đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy ca sĩ có id " + id + " để xóa.");
    }

    public Singer getSingerById(int id) {
        for (Singer singer : singerArr) {
            if (singer != null && singer.getSingerId() == id) {
                return singer;
            }
        }
        return null;
    }
    


    public void searchSongByNameOrGenre(Scanner scanner) {
        System.out.println("Mời bạn nhập tên bài hát hoặc thể loại cần tìm:");
        String search = scanner.nextLine();
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] != null && (singerArr[i].singerName.contains(search) || singerArr[i].singerGenre.contains(search))) {
                if (singerArr[i] != null) {
                    singerArr[i].displayData();
                }
            }
        }
    }
    public void searchSingerByNameOrGenre(Scanner scanner) {
        boolean found = false;
        System.out.println("Nhập từ khóa tìm kiếm (tên ca sĩ hoặc thể loại):");
        String keyword = scanner.nextLine().toLowerCase();
        for (Singer singer : singerArr) {
            if (singer != null && (singer.getSingerName().toLowerCase().contains(keyword) || singer.getSingerGenre().toLowerCase().contains(keyword))) {
                singer.displayData();
                found = true;
            }
        }
        // Nếu không tìm thấy ca sĩ thỏa mãn điều kiện
        if (!found) {
            System.out.println("Không tìm thấy ca sĩ.");
        }
    }




}