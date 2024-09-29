document.querySelector("#boton1").addEventListener("click", () => {
    console.log ("gogogo");
  const boton = document.getElementsByClassName("modal");
    boton[0].className="modal shown"
    console.log (boton[0]);
  });
  document.querySelector(".modal").addEventListener("click", (e) => {
    e.currentTarget.className = "modal hidden";
  });

document.querySelector(".display").addEventListener("click", (e) => {
    e.stopPropagation();
  });