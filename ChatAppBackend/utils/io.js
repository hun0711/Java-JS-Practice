const userController = require("../Controllers/user.controller");
const roomController = require("../Controllers/room.controller");
const chatController = require("../Controllers/chat.controller");

module.exports = function (io) {
  //io 관련 코드 작성 emit : 말하기, on : 듣기
  io.on("connection", async (socket) => {
    socket.emit("rooms", await roomController.getAllRooms());
    console.log("client is connected", socket.id);

    socket.on("login", async (userName, cb) => {
      //유저 정보 저장 함수
      try {
        const user = await userController.saveUser(userName, socket.id);
        const welcomeMessage = {
          chat: `${user.name} is joined to this room`,
          user: { id: null, name: "system" },
        };
        io.emit("message" , welcomeMessage)
        cb({ ok: true, data: user });
      } catch (error) {
        cb({ ok: false, error: error.message });
      }
    });

    socket.on("sendMessage", async (message, cb) => {
      try {
        //유저 찾기 socket id로
        const user = await userController.checkUser(socket.id);
        //메시지 저장(유저 )
        const newMessage = await chatController.saveChat(message, user);
        io.emit("message", newMessage);
        cb({ ok: true });
      } catch (error) {
        cb({ ok: false, error: error.message });
      }
    });

    socket.on("disconnected", () => {
      console.log("user is disconnected");
    });
  });
};
