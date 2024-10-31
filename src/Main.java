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
            throw new WrongLoginException("Неверный логин");
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

    public static void main(String[] args) {
        System.out.println("Hello world!");
        authValidation("login                                   ", "password", "password");

        char symbol;
        for (symbol=0; symbol < 255; symbol++) {
            System.out.println((int)symbol + " " + symbol);
        }
    }


}