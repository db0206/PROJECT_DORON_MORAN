package Login;

import Beans.Company;
import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;

public class LoginManager {

    private static LoginManager instance = null;

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    private LoginManager() {

    }

    public ClientFacade login(String email, String password, ClientType clientType) {
      return null;
    }
}
