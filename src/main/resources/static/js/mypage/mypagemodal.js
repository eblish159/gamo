document.getElementById("openModal").addEventListener("click", function () {
    document.getElementById("infoModal").style.display = "block";
  });

  document.querySelector(".close-btn").addEventListener("click", function () {
    document.getElementById("infoModal").style.display = "none";
  });

  document.querySelector(".cancel-btn").addEventListener("click", function () {
    document.getElementById("infoModal").style.display = "none";
  });