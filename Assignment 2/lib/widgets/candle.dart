import 'package:flutter/material.dart';

class Candle extends StatelessWidget {
  const Candle({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 200,
      width: 100,
      child: Stack(
        alignment: Alignment.center,
        children: [
          Positioned(
            top: 0,
            child: Image.asset(
              "assets/images/flame.gif",
              width: 40,
              height: 50,
            ),
          ),
          Positioned(
            top: 30,
            child: Container(
              height: 15,
              width: 2,
              color: Colors.white60,
            ),
          ),
          Positioned(
            top: 45,
            child: Container(
              height: 100.0,
              width: 20.0,
              decoration: const BoxDecoration(
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20),
                  topRight: Radius.circular(20),
                ),
                gradient: LinearGradient(
                  begin: Alignment(-1.0, 0),
                  end: Alignment(1, 0),
                  colors: [
                    Colors.white,
                    Color(0xffe2a970),
                    Color(0xffe2a970),
                    Color(0xffe2a970),
                    Color(0xffe2a970),
                    Colors.white,
                  ],
                ),
              ),
              child: const Center(
                child: Text(''),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
