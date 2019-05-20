package com.routes.usingmvp.Presenter;

import com.routes.usingmvp.Model.User;

public class MainActivityPresenter {

    private User user;
    private View view;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
    }

    public void updateFullName(String fullName){
        user.setFullName(fullName);
        view.updateUserInfoTextView(user.toString());

    }

    public void updateEmail(String email){
        user.setEmail(email);
        view.updateUserInfoTextView(user.toString());

    }

    public void userNameStrong(String fullName){

        int userNameLength = fullName.length();

        if (userNameLength <= 5) view.userNameStrong("Small");
        if (userNameLength > 5){

            view.userNameStrong(userNameLength <= 10 ? "Medium" : "Large");

        }

    }

    public interface View{

        void updateUserInfoTextView(String info);
        void userNameStrong(String usernameStrong);
        void showProgressBar();
        void hideProgressBar();

    }
}
