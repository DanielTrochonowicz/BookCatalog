package com.example.demo.service.impl;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
class InMemoryBookService implements BookService {

    private Map<Long, Book> books;
  //  private Book book;

    {
        books = new HashMap<>();
        books.put(1L, new Book(1L, "Wyrok", "33325342", "Oryński zastępuje Chyłkę w kancelarii Żelazny & McVay. Do prowadzenia pierwszej sprawy zmusza go sam Piotr Langer. Kordian nie ma wyboru – podejmuje się obrony siedemnastolatka z Poznania, oskarżonego o krwawe zabójstwo kolegów ze szkoły." + "\n" +
                "Chyłka jest przekonana, że tym razem sprawy nie da się wygrać.",
                2019, "Remigiusz Mróz"));
        books.put(2L, new Book(2L, "Czysty kod", "12325342", "Poznaj najlepsze metody tworzenia doskonałego kodu" + "\n" +
                "Jak pisać dobry kod, a zły przekształcić w dobry?" + "\n" +
                "Jak formatować kod, aby osiągnąć maksymalną czytelność?" + "\n" +
                "Jak implementować pełną obsługę błędów bez zaśmiecania logiki kodu?" + "\n" +
                "O tym, ile problemów sprawia niedbale napisany kod, wie każdy programista. Nie wszyscy jednak wiedzą, jak napisać ten świetny, „czysty” kod i czym właściwie powinien się on charakteryzować. Co więcej – jak odróżnić dobry kod od złego? Odpowiedź na te pytania oraz sposoby tworzenia czystego, czytelnego kodu znajdziesz właśnie w tej książce. Podręcznik jest obowiązkową pozycją dla każdego, kto chce poznać techniki rzetelnego i efektywnego programowania." +
                "\n" +
                "W książce „Czysty kod. Podręcznik dobrego programisty” szczegółowo omówione zostały zasady, wzorce i najlepsze praktyki pisania czystego kodu." +
                " Podręcznik zawiera także kilka analiz przypadków o coraz większej złożoności, z których każda jest doskonałym ćwiczeniem porządkowania zanieczyszczonego bądź nieudanego kodu. Z tego podręcznika dowiesz się m.in., jak tworzyć dobre nazwy, obiekty i funkcje, a także jak tworzyć testy jednostkowe i korzystać z programowania sterowanego testami. Nauczysz się przekształcać kod zawierający problemy w taki, który jest solidny i efektywny." + "\n" +
                "Nazwy klas i metod" + "\n" +
                "Funkcje i listy argumentów" + "\n" +
                "Rozdzielanie poleceń i zapytań" + "\n" +
                "Stosowanie wyjątków" + "\n" +
                "Komentarze" + "\n" +
                "Formatowanie" + "\n" +
                "Obiekty i struktury danych" + "\n" +
                "Obsługa błędów" + "\n" +
                "Testy jednostkowe" + "\n" +
                "Klasy i systemy" + "\n" +
                "Współbieżność" + "\n" +
                "Oczyszczanie kodu",
                2019, "Robert C. Martin"));
        books.put(3L, new Book(3L, "Microsoft SQL Server 2014", "32415342", "Microsoft SQL Server 2014 to najnowsza wersja serwera bazodanowego firmy Microsoft. Ta platforma jest rozwijana od ponad 25 lat, a każda kolejna jej wersja wprowadza serię ulepszeń — zarówno w obszarze możliwości, jak i wydajności. Jednak sam rozwój serwera nie wystarczy, żeby błyskawicznie wyciągać z bazy danych kluczowe informacje. Konieczna jest także optymalizacja parametrów jego pracy oraz zadawanych zapytań SQL.",
                2014, "Benjamin Nevarez"));
        books.put(4L, new Book(4L, "Python dla każdego", "89025342", "Wcześniejsze doświadczenie nie jest wymagane, aby nauczyć się programowania w Pythonie\n" +
            "Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych systemów operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który zdejmuje z programisty obowiązek panowania nad tym skomplikowanym obszarem.",
            2012, "Michael Dawson"));
        books.put(5L, new Book(5L, "Klatka", "73425342", "Siedem osób. Wszyscy zamknięci w ciasnym budynku, dzień po dniu oddalają się od rzeczywistości. Łączą ich studia we Wrocławiu. Dzieli wszystko inne. Początkowo są pewni siebie i otwarci na nowe doznania, chętnie rzucają się w maraton niekończących się imprez. Jednak beztroska atmosfera szybko mija. Ciągłe towarzystwo tych samych ludzi. Zamroczenie używkami. Brak perspektyw. Kompleksy. Strach..",
                2013, "Lilja Sigurdardottir"));
        books.put(6L, new Book(6L, "Flota Alfa", "Tom: 1", "Kapitanowi Leo Blake’owi ludzkość zawdzięcza zarówno swoje przetrwanie, jak i obecne kłopoty. Gdy nad Ziemią ze świetlistych wyrw w czasoprzestrzeni wyłaniają się tajemnicze okręty, sławny dowódca zostaje ponownie wezwany do czynnej służby. Nowo przybyła flota nie jest jednak tym, czym się wydaje, a Blake nie ma pewności, czy dotychczasowi sojusznicy ludzkości są godni zaufania. Każdy błąd.",
                2017, "B.V. Larson"));

     // Collections.sort(books, Comparator.comparing(b -> b.getId));
    //   Collections.sort(books, Comparator.comparing(Book::getId));

//        book = new Book();
//        book.setTitle("Rana");
//        book.setAuthor("Wojciech Chmielarz");
//        book.setYear("2019-08-14");
//        book.setDescription("WYSYŁAMY W 24H");
//        book.setIsbn("Tom: 1");
//        book.setId(1L);
    }

    @Override
    public List<Book> getBooks(){
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(Long bookId) {
        return books.get(bookId);
    }

    @Override
    public void removeBook(Long id) {
        books.remove(id);
    }

    @Override
    public Book addBook(Book book) {
        Long id = book.getId();
        if (book.getId() == null){
            id = generateId();
        }
        book.setId(id);
        return books.put(id, book);
    }
    private Long generateId(){
        long max = 0;
        for (long key: books.keySet()){
            max = Math.max(max, key);
        }
        return max + 1;
    }
}
