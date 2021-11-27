import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart' as http;
import 'package:workhop_7/screens/register.dart';
import 'package:workhop_7/models/user.dart';


import 'dashboard.dart';

class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final _formKey = GlobalKey<FormState>();
  User user = User("", "");
  String url = "http://10.0.2.2:8080/login";
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  Future save(user) async {
    var res = await http.post(Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({'email': user.email, 'password': user.password}));
    print(res.body);
    if (res.body != null) {
      Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => Dashboard(),
          ));
    }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
            child: SingleChildScrollView(
                child: Form(
                    key: _formKey,
                    child: Column(
                        //mainAxisAlignment: MainAxisAlignment.center,
                        //crossAxisAlignment: CrossAxisAlignment.center,
                        children: <Widget>[
                            SizedBox(
                        height: 200,
                        child: Image.asset(
                          "assets/loginicone.png",
                          fit: BoxFit.contain,
                        )),
                          Container(
                            height: 520.0,
                            width: 340.0,
                            child:  Padding(
                              padding:  EdgeInsets.all(10.0),
                              child:  Column(
                                 children: [
                                  Text("Login",style: GoogleFonts.oswald(
                                    fontWeight: FontWeight.w700,
                                    fontSize: 50,
                                    color:Colors.black45
                                  )),
                                const Align(
                                  alignment:Alignment.center ,
                                ),
                                TextFormField(
                                  controller:emailController ,
                                  decoration: InputDecoration(
                                      labelText: "Email"
                                  ),
                                ),
                                const SizedBox(
                                  height: 10.0,
                                ),
                                TextFormField(
                                  controller:passwordController ,
                                  decoration: InputDecoration(
                                        labelText: "Password"
                                  ),
                                ),
                                const SizedBox(
                                  height: 10.0,
                                ),
                                Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Text("Don't have an account? "),
                          GestureDetector(
                            onTap: () {
                              Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) =>
                                          Register()));
                            },
                            child: Text(
                              "SignUp",
                              style: TextStyle(
                                  color: Colors.redAccent,
                                  fontWeight: FontWeight.bold,
                                  fontSize: 15),
                            ),
                          )
                        ]),

                            ElevatedButton(
                                    style: TextButton.styleFrom(
                                      textStyle: const TextStyle(fontSize: 20),
                                      backgroundColor: const Color.fromRGBO(233, 65, 82, 1),
                                      shape:RoundedRectangleBorder(
                                          borderRadius: BorderRadius.circular(50)
                                      ),
                                    ),
                                    onPressed: (){
                                      if(_formKey.currentState!.validate())
                                      {
                                        save(User(emailController.text,passwordController.text));
                                      }
                                    },
                                    
                                  ),


                                ],
                              ),
                            ),
                          ),

                        ]
                    )
                )
            )
        )
    );
  }
}
