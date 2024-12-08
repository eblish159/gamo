const menuItems = document.querySelectorAll(".sidebar-menu__link");

menuItems.forEach((menuItem) => {
  menuItem.addEventListener("click", (e) => {
    const activeItem = document.querySelector(".sidebar-menu__link.active");
    if (activeItem) activeItem.classList.remove("active");
    e.target.classList.add("active");
  });
});