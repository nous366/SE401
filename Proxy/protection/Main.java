interface Folder {
    void performOperations();
}

class RealFolder implements Folder {
    public void performOperations() {
        System.out.println("Performing operation in the folder.");
    }
}

class ProtectedFolder implements Folder {
    private Folder folder;
    private String password;

    public ProtectedFolder(Folder folder, String password) {
        this.folder = folder;
        this.password = password;
    }

    public void performOperations() {
        if (this.authenticate()) {
            folder.performOperations();
        } else {
            System.out.println("You don't have access to this folder.");
        }
    }

    private boolean authenticate() {
        // Check the password; assuming "mypassword" is correct
        return "mypassword".equals(password);
    }
}
public class Main {
    public static void main(String[] args) {
        Folder folder = new ProtectedFolder(new RealFolder(), "mypassword");
        folder.performOperations();  // Thực hiện thành công
        Folder folderWithWrongPassword = new ProtectedFolder(new RealFolder(), "wrongpassword");
        folderWithWrongPassword.performOperations();  // Truy cập bị từ chối
    }
}
