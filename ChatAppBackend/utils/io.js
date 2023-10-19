const userController = require("../Controllers/user.controller");

module.exports = function (io) {
  //io 관련 코드 작성 emit : 말하기, on : 듣기
  io.on("connection", async (socket) => {
    console.log("client is connected", socket.id);

    socket.on("login", async (userName, cb) => {
      //유저 정보 저장 함수
      try {
        const user = await userController.saveUser(userName, socket.id);
        cb({ ok: true, data: user });
      } catch (error) {
        cb({ ok: false, error: error.message });
      }
    });

    socket.on("disconnected", () => {
      console.log("user is disconnected");
    });
  });
};
