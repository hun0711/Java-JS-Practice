module.exports = function (io) {
  //io 관련 코드 작성 emit : 말하기, on : 듣기
  io.on("connection", async (socket) => {
    console.log("client is connected", socket.id);
  });
};
