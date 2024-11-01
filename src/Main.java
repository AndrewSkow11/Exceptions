public class Main {

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }

        char[] loginCharArray = login.toCharArray();
        // разрешённые символы: 48-57 - цифры, 65-90 - большие буквы, 95 - подчёркивание, 97-122 - маленькие буквы
        // запрещённые символы 0-47, 58-64, 91-94, 96, более 122


        for (int i = 0; i < loginCharArray.length; i++) {
            if (loginCharArray[i] <= 47) {
                throw new WrongLoginException("Использован символ в диапазоне 0-47: " + (int) loginCharArray[i] + " (" + loginCharArray[i] + ")");
            }
            if (loginCharArray[i] >= 58 && loginCharArray[i] <= 64) {
                throw new WrongLoginException("Недопустимый символ в диапазоне 58 - 64: " + (int) loginCharArray[i] + " (" + loginCharArray[i] + ")");
            }
            if (loginCharArray[i] >= 91 && loginCharArray[i] <= 94) {
                throw new WrongLoginException("Недопустимый символ в диапазоне 91 - 94: " + (int) loginCharArray[i] + " (" + loginCharArray[i] + ")");
            }
            if (loginCharArray[i] == 96) {
                throw new WrongLoginException("Недопустимый символ 96: " + (int) loginCharArray[i] + " (" + loginCharArray[i] + ")");
            }
            if (loginCharArray[i] > 122) {
                throw new WrongLoginException("Недопустимый символ > 122: " + (int) loginCharArray[i] + " (" + loginCharArray[i] + ")");
            }
        }
    }


    public static void checkPassword(String password) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException("Слишком длинный пароль");
        }

        char[] passwordCharArray = password.toCharArray();
        // разрешённые символы: 48-57 - цифры, 65-90 - большие буквы, 95 - подчёркивание, 97-122 - маленькие буквы
        // запрещённые символы 0-47, 58-64, 91-94, 96, более 122


        for (int i = 0; i < passwordCharArray.length; i++) {
            if (passwordCharArray[i] <= 47) {
                throw new WrongPasswordException("Использован символ в диапазоне 0-47: " + (int) passwordCharArray[i] + " (" + passwordCharArray[i] + ")");
            }
            if (passwordCharArray[i] >= 58 && passwordCharArray[i] <= 64) {
                throw new WrongPasswordException("Недопустимый символ в диапазоне 58 - 64: " + (int) passwordCharArray[i] + " (" + passwordCharArray[i] + ")");
            }
            if (passwordCharArray[i] >= 91 && passwordCharArray[i] <= 94) {
                throw new WrongPasswordException("Недопустимый символ в диапазоне 91 - 94: " + (int) passwordCharArray[i] + " (" + passwordCharArray[i] + ")");
            }
            if (passwordCharArray[i] == 96) {
                throw new WrongPasswordException("Недопустимый символ 96: " + (int) passwordCharArray[i] + " (" + passwordCharArray[i] + ")");
            }
            if (passwordCharArray[i] > 122) {
                throw new WrongPasswordException("Недопустимый символ > 122: " + (int) passwordCharArray[i] + " (" + passwordCharArray[i] + ")");
            }
        }
    }

    public static void authValidation(String login, String password, String confirmPassword) {
        System.out.println("Вызван метод валидации логина и пароля");
        try {
            checkLogin(login);
            checkPassword(password);
        } catch (WrongLoginException e) {
            System.out.println("Логин более 20 символов или содержит недопустимый символ, попробуйте ещё раз!");
        }
        catch (WrongPasswordException e) {
            System.out.println("Пароль более 20 символов или содержит недопустимый символ, попробуйте ещё раз!");
        }
        finally {
            System.out.println("Длина логина: " + login.length());
            System.out.println("Длина пароля: " + password.length());
        }


    }

    public static void main(String[] args) throws WrongLoginException {
        authValidation("login", "password", "password");
        checkLogin("_jhkl");
    }


}