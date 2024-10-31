public class Main {

    public static class WrongLoginException extends Exception {
        public WrongLoginException () {
            super();
        }

        public WrongLoginException (String message) {
            super(message);
        }
    }

    public static void checkLogin (String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }

        char [] loginCharArray = login.toCharArray();
        // разрешённые символы: 48-57 - цифры, 65-90 - большие буквы, 95 - подчёркивание, 97-122 - маленькие буквы

        for (int i = 0; i < loginCharArray.length; i++) {
            if (loginCharArray[i] < 48)  {
                throw new WrongLoginException("Использован символ меньше 48");
            }
            if (loginCharArray[i] > 57 && loginCharArray[i] < 65) {
                throw new WrongLoginException("Недопустимый символ в диапазоне 58 - 64");
            }
        }
    }

    public static void authValidation(String login, String password, String confirmPassword) {
        System.out.println("Вызван метод валидации логина и пароля");

//        Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
//                Например, java_skypro_go.
//                У параметра login есть ограничение по длине – он должен быть равен или меньше 20 символов.
//                Если login длиннее 20 символов или содержит в себе недопустимые символы,
//                то необходимо выбросить исключение – WrongLoginException.
//
        try {
            checkLogin(login);
        }
        catch (WrongLoginException e) {
            System.out.println("Логин более 20 символов, попробуйте ещё раз!");
        }
        finally {
            System.out.println("Длина логина: " + login.length());
        }



    }

    public static void main(String[] args) throws WrongLoginException {
        System.out.println("Hello world!");
        authValidation("login                                   ", "password", "password");

        char symbol;
        for (symbol=0; symbol < 255; symbol++) {
            System.out.println((int)symbol + " " + symbol);
        }

        // разрешённые символы: 48-57 - цифры, 65-90 - большие буквы, 95 - подчёркивание, 97-122 - маленькие буквы


        //checkLogin("1111111jflsl                        ");
        checkLogin("!>");
    }


}