package takeout.mainweb.Controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.Service.LoginService;
import takeout.mainweb.component.*;
import takeout.mainweb.entiy.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@Api("用户功能")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    UserMapper userMapper;

    @ApiOperation("登录方法")
    @RequestMapping (value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestParam("username") String name,
                                @RequestParam("password") String pwd,
                                HttpServletResponse response,
                                HttpSession session){

        return loginService.login(name,pwd);

    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @ApiOperation("退出方法")
    @RequestMapping(value="/user/logout",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult logout(){
        return loginService.logout();

    }

    @ApiOperation("注册方法")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Object regist(@RequestParam("username") String name,
                         @RequestParam("password") String pwd) {
        String id = KeyUtil.getUniqueKey();
        User user = new User(id, name, pwd, "user", "", 0);
        int insert = userMapper.insert(user);
        return JSON.toJSONString(new JsonUtils(0, "注册成功"));

    }

}
