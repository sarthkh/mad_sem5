import 'package:diwali/widgets/candle.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  bool isDiyaLit = false;
  int acceptedData = 0;

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return Scaffold(
      extendBody: true,
      body: Stack(
        alignment: Alignment.center,
        children: <Widget>[
          Container(
            width: size.width,
            height: size.height,
            color: const Color(0xff533263),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                const Text(
                  "Happy\n✦ Diwali ✦",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    height: 1.8,
                    fontWeight: FontWeight.bold,
                    fontSize: 40,
                    color: Color.fromARGB(255, 255, 140, 0),
                  ),
                ),
                Image.asset("assets/images/diya.png"),
                const Padding(
                  padding: EdgeInsets.all(20.0),
                  child: Text.rich(
                    TextSpan(
                      text:
                          "May the festival of light, light up new paths and bring peace, prosperity, and happiness ❤‍🔥 \n\n~ Best wishes from \n\n",
                      style: TextStyle(
                        height: 1.5,
                        fontSize: 20,
                        color: Colors.white,
                      ),
                      children: <TextSpan>[
                        TextSpan(
                          text: "Sarthak Khandelwal - B079",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            color: Color.fromARGB(255, 255, 140, 0),
                          ),
                        ),
                      ],
                    ),
                    textAlign: TextAlign.center,
                  ),
                ),
              ],
            ),
          ),
          AnimatedPositioned(
            width: isDiyaLit ? 0 : size.width * 4,
            height: isDiyaLit ? 0 : size.height * 4,
            duration: const Duration(milliseconds: 500),
            child: Container(
              decoration: const BoxDecoration(
                shape: BoxShape.circle,
                color: Color(0xff3b3b3b),
              ),
            ),
          ),
          Lottie.asset(
            'assets/animation.json',
            width: size.width,
            height: size.height,
            fit: BoxFit.cover,
          ),
          if (!isDiyaLit) ...[
            const Positioned(
              top: 50,
              child: Draggable(
                data: 10,
                feedback: Candle(),
                childWhenDragging: SizedBox(),
                child: Candle(),
              ),
            ),
            Center(
              child: DragTarget<int>(
                builder: (
                  BuildContext context,
                  List<dynamic> accepted,
                  List<dynamic> rejected,
                ) {
                  return Image.asset("assets/images/unlit_diya.png");
                },
                onAccept: (int data) {
                  setState(() {
                    isDiyaLit = !isDiyaLit;
                  });
                },
              ),
            ),
            Positioned(
              bottom: 60,
              width: size.width,
              child: const Padding(
                padding: EdgeInsets.all(20.0),
                child: Text(
                  "Light the diya and celebrate Diwali with me ✦",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    height: 1.8,
                    fontWeight: FontWeight.bold,
                    fontSize: 22,
                    color: Colors.white,
                  ),
                ),
              ),
            ),
          ],
        ],
      ),
    );
  }
}
