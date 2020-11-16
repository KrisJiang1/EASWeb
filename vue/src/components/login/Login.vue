<template>
  <div class="login-bg-plain stain">
    <div class="form-basic" id="login">
      <div class="form-content">
        <div class="login-header">
          <div class="logo">
            <span class="color">用户登录</span>
          </div>
        </div>
        <form name="loginform" action="http://localhost:8090/eas/userLogin" method="post">
          <table>
            <tbody>
            <tr>
              <td>
                <input id="email" type="text" name="userName" placeholder="用户名" value="" tabindex="1">
              </td>
            </tr>

            <tr>
              <td>
                <input type="password" name="userPwd" placeholder="密码" value="" tabindex="2">
              </td>
            </tr>

            <tr>
              <td class="remember-me-td">
                <label class="remember-me" for="remember_me"><input type="checkbox" id="remember_me" tabindex="3" name="data[remember]" value="1">记住帐号</label><span class="forgot-pass"><a href="http://demo2.cssmoban.com/auth/password-recovery" class="" tabindex="5">忘记密码?</a></span>
              </td>
            </tr>
            <tr>
              <td style="text-align: center;">
                <input type="submit" class="login-btn" value="登录" tabindex="4">
              </td>
            </tr>
            </tbody>
          </table>
        </form>

        <div class="login-footer">
          <span>没有帐号? <a href="">点击注册</a></span>
        </div>
      </div>
    </div>
  </div>

</template>

<script>


export default {
  name: "Login"
}
</script>

<style scoped>

body { background-color: #f3f3f3; font-family: "-apple-system", "BlinkMacSystemFont", "Segoe UI", Roboto, "Oxygen-Sans", Ubuntu, Cantarell, "Fira Sans", "Helvetica Neue", Arial, sans-serif; margin: 0; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale; }

body, html { height: 100%; }

html { font-size: 16px; }

@media screen and (max-width: 1440px) { html { font-size: 12px; } }
.form-basic { background-color: #ffffff; justify-content: center; display: inline-flex; }

.title { color: #383838; font-size: 30px; }

.form-content { width: 100%; display: block; }

.login-bg, .login-bg-plain { height: 100%; width: 100%; background-attachment: scroll; background-position: 50% 0; background-repeat: no-repeat; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover; -webkit-transition: background 2s; -moz-transition: background 2s; -o-transition: background 2s; transition: background 2s; }

.login-bg { background-color: #1a1a1a; }

.login-bg-plain { display: flex; justify-content: space-around; align-items: center; height: 100%; width: 100%; background-color: #ffffff; }

.stain { background: white}


*{font-family: "Century Gothic","Microsoft yahei";}
#signup, #signup-verify, #login, #password-recovery, #clients-area { font-family: "Century Gothic","Microsoft yahei"; color: #383838; font-size: 14px; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; width: 550px; margin: auto; }
#signup .login-footer, #signup .login-header, #signup-verify .login-footer, #signup-verify .login-header, #login .login-footer, #login .login-header, #password-recovery .login-footer, #password-recovery .login-header, #clients-area .login-footer, #clients-area .login-header { text-align: center; }
#signup .login-header, #signup-verify .login-header, #login .login-header, #password-recovery .login-header, #clients-area .login-header { padding: 80px 0 0; -webkit-border-radius: 4px 4px 0 0; -moz-border-radius: 4px 4px  0 0; border-radius: 4px 4px 0 0; }
#signup .login-footer, #signup-verify .login-footer, #login .login-footer, #password-recovery .login-footer, #clients-area .login-footer { background-color: #fafafa; padding: 32px 0; -webkit-border-radius: 0 0 4px 4px; -moz-border-radius: 0 0 4px 4px; border-radius: 0 0 4px 4px; color: #999999; }
#signup .login-footer .login-link, #signup-verify .login-footer .login-link, #login .login-footer .login-link, #password-recovery .login-footer .login-link, #clients-area .login-footer .login-link { color: #26c644; }
#signup .logo, #signup-verify .logo, #login .logo, #password-recovery .logo, #clients-area .logo { width: 180px; height: 35.8px; margin: 0 auto; }
#signup .logo span, #signup-verify .logo span, #login .logo span, #password-recovery .logo span, #clients-area .logo span { display: block; width: 100%; height: 100%; }
#signup form, #signup-verify form, #login form, #password-recovery form, #clients-area form { padding: 40px 100px 0; }
#signup form td input, #signup-verify form td input, #login form td input, #password-recovery form td input, #clients-area form td input { width: 100%; }
#signup .oauth2form, #signup-verify .oauth2form, #login .oauth2form, #password-recovery .oauth2form, #clients-area .oauth2form { padding: 0 100px; }
#signup form:last-of-type, #signup-verify form:last-of-type, #login form:last-of-type, #password-recovery form:last-of-type, #clients-area form:last-of-type { padding-bottom: 30px; }
#signup .logo .color, #signup-verify .logo .color, #login .logo .color, #password-recovery .logo .color, #clients-area .logo .color { font-size: 20px; }
#signup .page-title, #signup-verify .page-title, #login .page-title, #password-recovery .page-title, #clients-area .page-title { font-size: 30px; padding-bottom: 16px; text-align: center; color: #383838; }
#signup .password-title, #signup-verify .password-title, #login .password-title, #password-recovery .password-title, #clients-area .password-title { padding: 15px 30px 5px 30px; text-align: center; }
#signup .page-title-small, #signup-verify .page-title-small, #login .page-title-small, #password-recovery .page-title-small, #clients-area .page-title-small { font-size: 14px; padding-bottom: 16px; text-align: center; color: #999999; line-height: 1.5; }
#signup a, #signup-verify a, #login a, #password-recovery a, #clients-area a { color: #26c644; text-decoration: none; }
#signup a:hover, #signup-verify a:hover, #login a:hover, #password-recovery a:hover, #clients-area a:hover { text-decoration: underline; }
#signup *, #signup-verify *, #login *, #password-recovery *, #clients-area * { -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; }
#signup table, #signup-verify table, #login table, #password-recovery table, #clients-area table { border-collapse: collapse; border-spacing: 0; width: 100%; }
#signup td, #signup-verify td, #login td, #password-recovery td, #clients-area td { padding: 0 0 20px; }
#signup td.remember-me-td, #signup-verify td.remember-me-td, #login td.remember-me-td, #password-recovery td.remember-me-td, #clients-area td.remember-me-td { color: #383838; display: flex; padding: 0 0 19px; justify-content: space-between; }
#signup .remember-me, #signup-verify .remember-me, #login .remember-me, #password-recovery .remember-me, #clients-area .remember-me { display: inline-block; padding-left: 15px; text-indent: -15px; }
#signup .remember-me input, #signup-verify .remember-me input, #login .remember-me input, #password-recovery .remember-me input, #clients-area .remember-me input { width: 14px; height: 14px; padding: 0; margin: 0 5px 0 0; vertical-align: middle; position: relative; top: -1px; *overflow: hidden; }
#signup *:focus, #signup-verify *:focus, #login *:focus, #password-recovery *:focus, #clients-area *:focus { outline: none; }
#signup input[type="submit"], #signup-verify input[type="submit"], #login input[type="submit"], #password-recovery input[type="submit"], #clients-area input[type="submit"] { margin-left: 0px; }
#signup input[type="submit"], #signup-verify input[type="submit"], #login input[type="submit"], #password-recovery input[type="submit"], #clients-area input[type="submit"] { -webkit-box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; -moz-box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; height: 45px; font-size: 14px; color: #FFFFFF; padding: 0 18px; background-color: #34c950; border: none; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; cursor: pointer; }
#signup input[type="submit"]:hover, #signup-verify input[type="submit"]:hover, #login input[type="submit"]:hover, #password-recovery input[type="submit"]:hover, #clients-area input[type="submit"]:hover { background-color: #00c224; border-color: #2acb48; -webkit-box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); -moz-box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); }
#signup input[type="submit"].login-btn, #signup-verify input[type="submit"].login-btn, #login input[type="submit"].login-btn, #password-recovery input[type="submit"].login-btn, #clients-area input[type="submit"].login-btn { width: 100%; }
#signup input[type="submit"].google-btn:hover, #signup-verify input[type="submit"].google-btn:hover, #login input[type="submit"].google-btn:hover, #password-recovery input[type="submit"].google-btn:hover, #clients-area input[type="submit"].google-btn:hover { background-color: #fff; border: 1px solid #4385f4; -webkit-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.25); -moz-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.25); box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.25); }
#signup input[type="submit"].github-btn, #signup-verify input[type="submit"].github-btn, #login input[type="submit"].github-btn, #password-recovery input[type="submit"].github-btn, #clients-area input[type="submit"].github-btn { width: 100%; background-color: #2a2a2a; border: 1px solid #2a2a2a; }
#signup input[type="submit"].github-btn:hover, #signup-verify input[type="submit"].github-btn:hover, #login input[type="submit"].github-btn:hover, #password-recovery input[type="submit"].github-btn:hover, #clients-area input[type="submit"].github-btn:hover { background-color: #3a3a3a; border-color: #3a3a3a; -webkit-box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.25); -moz-box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.25); box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.25); }
#signup input[type="submit"].signup-btn, #signup-verify input[type="submit"].signup-btn, #login input[type="submit"].signup-btn, #password-recovery input[type="submit"].signup-btn, #clients-area input[type="submit"].signup-btn { width: 100%; }
#signup input[type="submit"]:active, #signup-verify input[type="submit"]:active, #login input[type="submit"]:active, #password-recovery input[type="submit"]:active, #clients-area input[type="submit"]:active { -webkit-box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 1px 1px 0px rgba(0, 0, 0, 0.16); -moz-box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 1px 1px 0px rgba(0, 0, 0, 0.16); box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 1px 1px 0px rgba(0, 0, 0, 0.16); }
#signup .sign-up-btn, #signup-verify .sign-up-btn, #login .sign-up-btn, #password-recovery .sign-up-btn, #clients-area .sign-up-btn { -webkit-box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; -moz-box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 1px 0px; height: 45px; text-decoration: none; color: #383838; padding: 11px 19px 10px 19px; background-color: #f4f4f4; border: 1px solid #dbdbdb; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; cursor: pointer; font-size: 12px; }
#signup .sign-up-btn:hover, #signup-verify .sign-up-btn:hover, #login .sign-up-btn:hover, #password-recovery .sign-up-btn:hover, #clients-area .sign-up-btn:hover { background-color: #eaeaea; border-color: #d1d1d1; -webkit-box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); -moz-box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); box-shadow: 0px 3px 7px 0px rgba(0, 0, 0, 0.1); }
#signup .sign-up-btn:active, #signup-verify .sign-up-btn:active, #login .sign-up-btn:active, #password-recovery .sign-up-btn:active, #clients-area .sign-up-btn:active { -webkit-box-shadow: inset 0px 3px 3px rgba(0, 0, 0, 0.07), rgba(0, 0, 0, 0.06) 0px 1px 1px 0px; -moz-box-shadow: inset 0px 3px 3px rgba(0, 0, 0, 0.07), rgba(0, 0, 0, 0.06) 0px 1px 1px 0px; box-shadow: inset 0px 3px 3px rgba(0, 0, 0, 0.07), rgba(0, 0, 0, 0.06) 0px 1px 1px 0px; }
#signup input[type="text"], #signup-verify input[type="text"], #login input[type="text"], #password-recovery input[type="text"], #clients-area input[type="text"] { font-family: "Century Gothic","Microsoft yahei";}
#signup input[type="text"], #signup input[type="password"], #signup-verify input[type="text"], #signup-verify input[type="password"], #login input[type="text"], #login input[type="password"], #password-recovery input[type="text"], #password-recovery input[type="password"], #clients-area input[type="text"], #clients-area input[type="password"] { font-size: 14px; height: 45px; margin: 0px; padding: 0px 7px; border-width: 1px; border-style: solid; border-color: #dbdbdb; background-color: #FFFFFF; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; width: 100%; }
#signup input[type="text"]:focus, #signup input[type="password"]:focus, #signup-verify input[type="text"]:focus, #signup-verify input[type="password"]:focus, #login input[type="text"]:focus, #login input[type="password"]:focus, #password-recovery input[type="text"]:focus, #password-recovery input[type="password"]:focus, #clients-area input[type="text"]:focus, #clients-area input[type="password"]:focus { border: 1px solid #34c950; }
#signup input[type="text"].error-validation, #signup input[type="password"].error-validation, #signup-verify input[type="text"].error-validation, #signup-verify input[type="password"].error-validation, #login input[type="text"].error-validation, #login input[type="password"].error-validation, #password-recovery input[type="text"].error-validation, #password-recovery input[type="password"].error-validation, #clients-area input[type="text"].error-validation, #clients-area input[type="password"].error-validation { border-color: #c82f00; border-bottom-right-radius: 0; border-bottom-left-radius: 0; }
#signup input[type="text"].normal-state, #signup input[type="password"].normal-state, #signup-verify input[type="text"].normal-state, #signup-verify input[type="password"].normal-state, #login input[type="text"].normal-state, #login input[type="password"].normal-state, #password-recovery input[type="text"].normal-state, #password-recovery input[type="password"].normal-state, #clients-area input[type="text"].normal-state, #clients-area input[type="password"].normal-state { border: 1px solid #d1d1d1; }
#signup input[type="text"].normal-state:focus, #signup input[type="password"].normal-state:focus, #signup-verify input[type="text"].normal-state:focus, #signup-verify input[type="password"].normal-state:focus, #login input[type="text"].normal-state:focus, #login input[type="password"].normal-state:focus, #password-recovery input[type="text"].normal-state:focus, #password-recovery input[type="password"].normal-state:focus, #clients-area input[type="text"].normal-state:focus, #clients-area input[type="password"].normal-state:focus { border: 1px solid #6eb755; }
#signup .label, #signup-verify .label, #login .label, #password-recovery .label, #clients-area .label { width: 120px; text-align: right; font-size: 12px; padding-right: 18px; }
#signup .verify-robot .login-header, #signup-verify .verify-robot .login-header, #login .verify-robot .login-header, #password-recovery .verify-robot .login-header, #clients-area .verify-robot .login-header { padding: 80px 0 20px; }
#signup .verify-robot .login-footer, #signup-verify .verify-robot .login-footer, #login .verify-robot .login-footer, #password-recovery .verify-robot .login-footer, #clients-area .verify-robot .login-footer { padding: 28px 0; }

#reset-password, #first-login, #page { font-family: "-apple-system", "BlinkMacSystemFont", "Segoe UI", Roboto, "Oxygen-Sans", Ubuntu, Cantarell, "Fira Sans", "Helvetica Neue", Arial, sans-serif; background-color: #ffffff; -webkit-box-shadow: 0px 26px 40px -35px rgba(0, 0, 0, 0.6); -moz-box-shadow: 0px 26px 40px -35px rgba(0, 0, 0, 0.6); box-shadow: 0px 26px 40px -35px rgba(0, 0, 0, 0.6); color: #383838; font-size: 14px; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; -webkit-border-radius: 5px; -moz-border-radius: 5px; -ms-border-radius: 5px; -o-border-radius: 5px; border-radius: 5px; padding-left: 70px; padding-right: 70px; padding-bottom: 30px; padding-top: 1px; }
#reset-password .page-title, #first-login .page-title, #page .page-title { font-size: 30px; padding-bottom: 16px; text-align: center; }
#reset-password a, #first-login a, #page a { color: #26c644; }
#reset-password *, #first-login *, #page * { -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; }
#reset-password table, #first-login table, #page table { border-collapse: collapse; border-spacing: 0px; }
#reset-password td, #first-login td, #page td { padding: 0px 0px 20px; }
#reset-password .remember-me, #first-login .remember-me, #page .remember-me { display: block; padding-left: 15px; text-indent: -15px; }
#reset-password .remember-me input, #first-login .remember-me input, #page .remember-me input { width: 17px; height: 17px; padding: 0; margin: 0 5px 0 0; vertical-align: middle; position: relative; top: 0; *overflow: hidden; }
#reset-password input[type="submit"], #first-login input[type="submit"], #page input[type="submit"] { margin-left: 0px; margin-right: 10px; }
#reset-password input[type="submit"], #first-login input[type="submit"], #page input[type="submit"] { -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 1px 0px; -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 1px 0px; box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 1px 0px; height: 45px; color: #FFFFFF; padding: 0px 18px; font-size: 12px; font-weight: bold; background-color: #34c950; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; cursor: pointer; }
#reset-password input[type="submit"]:hover, #first-login input[type="submit"]:hover, #page input[type="submit"]:hover { background-color: #00c224; border-color: #2acb48; }
#reset-password input[type="submit"]:active, #first-login input[type="submit"]:active, #page input[type="submit"]:active { -webkit-box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 2px 2px 0px rgba(0, 0, 0, 0.16); -moz-box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 2px 2px 0px rgba(0, 0, 0, 0.16); box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.2), 0px 2px 2px 0px rgba(0, 0, 0, 0.16); }
#reset-password input[type="text"], #first-login input[type="text"], #page input[type="text"] { font-family: "-apple-system", "BlinkMacSystemFont", "Segoe UI", Roboto, "Oxygen-Sans", Ubuntu, Cantarell, "Fira Sans", "Helvetica Neue", Arial, sans-serif; }
#reset-password input[type="text"], #reset-password input[type="password"], #first-login input[type="text"], #first-login input[type="password"], #page input[type="text"], #page input[type="password"] { font-size: 14px; height: 45px; width: 290px; margin: 0px; padding: 0px 7px; border-width: 1px; border-style: solid; border-color: #d1d1d1 #e7e7e7 #e7e7e7 #d1d1d1; background-color: #FFFFFF; -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; }
#reset-password .label, #first-login .label, #page .label { width: 120px; text-align: right; font-size: 12px; padding-right: 18px; }

#login, #first-login, #signup, #signup-verify, #reset-password, #password-recovery, #clients-area { border: 1px solid #e1e1e1; }
.separator { text-align: center; justify-content: center; display: flex; height: 50px; padding-top: 17px; }
.separator .separator-line { margin: 0 20px; border-top: 1px solid #e1e1e1; width: 124px; height: 1px; }
.separator span { color: #777777; margin-top: -7px; }
.separator .login-btn { height: 45px; }

</style>
