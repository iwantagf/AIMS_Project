#### Tại sao sau khi chạy phương thức swap(s1, s2) thì tên của hai học sinh không thay đổi? Từ đó, Java là ngôn ngữ truyền tham trị hay tham chiếu?
Khi gọi phương thức ```swap(s1, s2)```, bản sao của ```s1``` và ```s2``` được chép vào hai biến lần lượt là ```o1``` và ```o2```. Lúc này, nếu ta chạy phương thức
```java
public static void swap(Object o1, Object o2) {
    Object tmp = o1;
    o1 = o2;
    o2 = tmp;
}
```
Thì chỉ có giá trị của ```o1``` và ```o2``` thay đổi, ```s1``` và ```s2``` giữ nguyên.

**Kết luận**: Java là ngôn ngữ truyền tham trị. Đối với một Object, giá trị được truyền chính là 1 reference của nó, không phải chính nó.


#### Làm thế nào để phương thức swap hoạt động?
Sử dụng setter và getter để thay đổi trực tiếp giá trị của Object được reference trỏ đến thay vì chỉ thay đổi giá trị được truyền vào.
