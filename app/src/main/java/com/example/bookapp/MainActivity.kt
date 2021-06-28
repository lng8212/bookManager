package com.example.bookapp

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapp.databinding.ActivityMainBinding
import com.example.bookapp.model.Book

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ); //enable full screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        initmdataBooks()
        setContentView(binding.root)
    }
    companion object{
        var mdata = mutableListOf<Book>()
    }
    private fun initmdataBooks() {
        mdata.add(
            Book(
                "90 Chân Dung Văn Hóa Văn Chương Việt",
                "90 Chân Dung Văn Hóa Văn Chương Việt - trong một tập sách ngàn trang, trước hết với GS. Phong Lê là điểm lại chân dung những đối tượng mà ông được nghiên cứu: đọc, học, khảo sát trong suốt hành trình nghề nghiệp gần 60 năm của mình.",
                "GS. Phong Lê",
                "",
                816,
                4,
                4.5F,
                R.drawable.book1
            )
        )
        mdata.add(
            Book(
                "Cẩm Nang Đầu Tư Và Quản Lý Tài Chính Cá Nhân",
                "Cẩm Nang Đầu Tư Và Quản Lý Tài Chính Cá Nhân - Cuốn sách nói về kỹ năng tối ưu hóa hiệu quả đầu tư với quy tắc “Tam giác vàng quản lý tài chính”.",
                "Phương Sĩ Duy",
                "",
                328,
                5,
                3.7F,
                R.drawable.book2
            )
        )
        mdata.add(
            Book(
                "Chữa Lành Cơ Thể - Yêu Cơ Thể Một Chút, Đời Vẻ Vang Nhiều Phần",
                "Chữa Lành Cơ Thể - Yêu Cơ Thể Một Chút, Đời Vẻ Vang Nhiều Phần - Tác giả Daisy Smith sẽ chia sẻ cho bạn những phương pháp, cách thức và lộ trình để bạn chữa lành cơ thể một cách khoa học và hiệu quả nhất, dựa trên sự thấu hiểu những tác hại do việc thừa cân mang lại và kinh nghiệm khi thất bại cũng như thành công trong việc giảm cân của cô và người thân xung quanh.",
                "Daisy Smith",
                "",
                264,
                20,
                4.5F,
                R.drawable.book3
            )
        )
        mdata.add(
            Book(
                "Đừng Vì Cô Đơn Mà Nắm Vội Một Bàn Tay",
                "Đừng Vì Cô Đơn Mà Nắm Vội Một Bàn Tay - Là cuốn sách cùng bạn đi qua những tháng ngày dập dìu hoang mang ở tuổi trưởng thành, để vững vàng chờ đón những điều tốt đẹp.",
                "Anna Turner",
                "",
                264,
                13,
                4.7F,
                R.drawable.book4
            )
        )
        mdata.add(
            Book(
                "Gột Rửa Âu Lo Tự Do Tâm Trí",
                "Gột Rửa Âu Lo Tự Do Tâm Trí - Cuốn sách bao gồm 100 bài thiền được sắp xếp vào 8 chủ đề với những mục đích khác nhau, giúp bạn đọc dễ dàng lựa chọn bài thiền phù hợp với không gian và thời gian cụ thể.",
                "Michael Smith",
                "",
                256,
                9,
                3.9F,
                R.drawable.book5
            )
        )
        mdata.add(
            Book(
                "Sống Lâu - 50+ Bí Quyết Sống Dẻo Dai Từ Vùng Đất Trường Thọ",
                "Sống Lâu - 50+ Bí Quyết Sống Dẻo Dai Từ Vùng Đất Trường Thọ - là một cuốn cẩm nang về sức khỏe mà bạn có thể tra cứu thông tin nhanh chóng.",
                "Karen Salmansohn",
                "",
                184,
                13,
                4.2F,
                R.drawable.book6
            )
        )
        mdata.add(
            Book(
                "Trí Thông Minh Của Sự Tinh Tế",
                "Trí Thông Minh Của Sự Tinh Tế - Cuốn sách giúp phụ nữ tìm thấy vẻ đẹp và “sức mạnh\" đích thực toát ra từ cốt cách bên trong!",
                "Tô Mạn",
                "",
                248,
                18,
                4.4F,
                R.drawable.book7
            )
        )
    }


}