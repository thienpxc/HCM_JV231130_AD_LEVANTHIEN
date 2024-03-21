package ra.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song  {
    private static int nextBookId =1;
    private int songId ;
    private String songName;
    private String songDescriptions;
    private Singer singer;
    private String songWriter;
    private int year;
    private boolean songStatus;

    public Song() {
    }

    public Song( String songName, String songDescriptions, String songWriter,Singer singer, int year, boolean songStatus) {
        this.songId = nextBookId++;
        this.songName = songName;
        this.songDescriptions = songDescriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.year = year;
        this.songStatus = songStatus;
    }


    public Song(Singer singer) {
        this.singer = singer;
    }


    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDescriptions() {
        return songDescriptions;
    }

    public void setSongDescriptions(String songDescriptions) {
        this.songDescriptions = songDescriptions;
    }



    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

//    @Override
//    public String toString() {
//        return "Song{" +
//                "songId=" + songId +
//                ", songName='" + songName + '\'' +
//                ", songDescriptions='" + songDescriptions + '\'' +
//                ", singerName='" + singer.getSingerName() + '\'' +
//                ", songWriter='" + songWriter + '\'' +
//                ", year=" + year +
//                ", songStatus=" + songStatus +
//                '}';
//    }
public void displayData() {
    System.out.printf("Mã bài hát: %d |", nextBookId++);
    System.out.printf("Tên bài hát: %s |", songName);
    System.out.printf("Mô tả bài hát: %s | \n", songDescriptions);
    System.out.printf("tên ca sĩ: %s |", singer.getSingerName());
    System.out.printf("Người sáng tác: %s |", songWriter);
    System.out.printf("Năm sáng tác: %d |",year);
    System.out.printf("Trang thai: %s  \n", (songStatus ? "Đang hoạt động" : "Không hoạt động"));

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

    Scanner scanner = new Scanner(System.in);
    private Song[] songArr = new Song[100];

    private Song inputData(Scanner scanner){
        System.out.println("Mời bạn nhập tên bài hát:");
        String songName = getInputFromUser(scanner,".+");
        System.out.println("Mời bạn nhập mô tả bài hát:");
        String songDescriptions = getInputFromUser(scanner,".+");
        System.out.println("Mời bạn nhập Id tên ca sĩ:");
        int singerId = Integer.parseInt(getInputFromUser(scanner,"\\d+"));
        Singer singer =this.singer.getSingerById(singerId);
        if (singer == null) {
            System.out.println("Ca sĩ không tồn tại. Mời bạn nhập thông tin ca sĩ mới:");
            singer = this.singer.inputData(scanner);
        }
        System.out.println("Mời bạn nhập tên người sáng tác :");
        String songWriter = getInputFromUser(scanner,".+");
        System.out.println("Mời bạn nhập năm phát hành :");
        int year = Integer.parseInt(getInputFromUser(scanner,"\\d+"));
        boolean songStatus = true;
        return new Song(songName,songDescriptions,songWriter,singer,year,songStatus);
    }


    public void addSong(Scanner scanner){
        System.out.println("Mời bạn nhập số lượng bài hát cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songArr.length; i++) {
            if (songArr[i] == null) {
                songArr[i] = inputData(scanner);
                number--;
            }
            if (number == 0) {
                break;
            }
        }
    }

    public void showSong() {
        for (int i = 0; i < songArr.length; i++) {
            if (songArr[i] != null) {
                System.out.println(songArr[i].toString());
            }
        }
    }

    public void changeSongById(){
        System.out.println("Mời bạn nhập id bài hát cần sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songArr.length; i++) {
            if (songArr[i] != null && songArr[i].getSongId() == id) {
                songArr[i] = inputData(scanner);
                break;
            }
        }
    }

    public void deleteSongById(Scanner scanner) {
        System.out.println("Mời bạn nhập id bài hát cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songArr.length; i++) {
            if (songArr[i] != null && songArr[i].getSongId() == id) {
                songArr[i] = null;
                break;
            }
        }
    }




}