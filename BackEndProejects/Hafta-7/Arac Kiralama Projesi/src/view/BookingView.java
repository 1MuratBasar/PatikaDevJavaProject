package view;

import business.BookManager;
import core.Helper;
import entity.Book;
import entity.Car;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingView extends Layout {
    private JPanel container;
    private JLabel lbl_car_info;
    private JTextField fld_book_name;
    private JTextField fld_book_idno;
    private JTextField fld_book_mpno;
    private JTextField fld_book_mail;
    private JTextField fld_book_strt_date;
    private JTextField fld_book_fnsh_date;
    private JTextField fld_book_prc;
    private JTextArea txta_book_note;
    private JButton btn_book_save;
    private Car car;
    private BookManager bookManager;
//*************************************************************************************************************
    //parametre olarak secilena arabaya ihtiyacım var
    public BookingView (Car selectedCar, String strt_date, String fnsh_date) {
        this.car = selectedCar;
        this.add(container);
        this.bookManager = new BookManager();
        guiInitialize(300,600);
//*************************************************************************************************************
        //müşteri hangi aracı seçtiyse araç bilgisi vermek için
        lbl_car_info.setText("Araç : " + this.car.getPlate() +
                " / " + this.car.getModel().getBrand().getName() +
                " / " + this.car.getModel().getName()
        );
//*************************************************************************************************************
        //hangi tarih aralıklarını seçtiyse göstermek için
        this.fld_book_strt_date.setText(strt_date);
        this.fld_book_fnsh_date.setText(fnsh_date);

//*************************************************************************************************************

        //test için varsayılan atandı. değiştirilebilmesi düzenlenebilir özelliği farklı
        //olacak. araa degiştirmek için yeni rezervasyon olması gibi
        //
        this.fld_book_name.setText("Murat Başar");
        this.fld_book_idno.setText("1234567891");
        this.fld_book_mail.setText("test2@test.com");
        this.fld_book_mpno.setText("05501234567");
        this.fld_book_prc.setText("2350");
        this.txta_book_note.setText("Not bırakıldı");
//*************************************************************************************************************

        btn_book_save.addActionListener(e -> {
            //hangi alanların dolu olup olmadıgını kontrol ediyorum
            JTextField[] checkFieldList = {

                    this.fld_book_name,
                    this.fld_book_mail,
                    this.fld_book_prc,
                    this.fld_book_idno,
                    this.fld_book_mpno,
                    this.fld_book_strt_date,
                    this.fld_book_fnsh_date
            };
//*************************************************************************************************************
            //bu checklist boş ise fill yap
            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMsg("fill");
            }else { // checklist bos degilse yeni bir book olustur
                Book book = new Book();
                book.setbCase("done");
                book.setCar_id(this.car.getId());
                book.setName(this.fld_book_name.getText());
                book.setStrt_date(LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setFnsh_date(LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setIdno(this.fld_book_idno.getText());
                book.setMpno(this.fld_book_mpno.getText());
                book.setMail(this.fld_book_mail.getText());
                book.setNote(this.txta_book_note.getText());
                book.setPrc(Integer.parseInt(this.fld_book_prc.getText()));

//*************************************************************************************************************
                if (this.bookManager.save(book)) { //usteki book u kaydet
                    Helper.showMsg("done");
                    dispose(); //işlem başarılıysa dispose et
                } else {
                    Helper.showMsg("error");
                }


//*************************************************************************************************************

            }
        });
    }


}
