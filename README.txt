# Tên Dự Án/Dịch Vụ
reward management
## Mô tả
Hệ thống quản lý trao thưởng (thẻ cào điện thoại) ở mức sơ giản

## Bắt Đầu

Dưới đây là hướng dẫn cách bắt đầu sử dụng dự án/dịch vụ.

### Yêu Cầu Hệ Thống
- Java 11
- Maven
- Database: oracle
### Cài Đặt

1. Clone dự án từ kho lưu trữ:

    git clone https://github.com/PhamTrung1993/reward_management
    git checkout dev

2. Di chuyển vào thư mục dự án:
    cd reward_management

3. Sử dụng Maven để biên dịch và đóng gói ứng dụng:
    mvn clean install


### Cấu Hình

1. Cấu hình cơ sở dữ liệu và các thông số khác trong tệp `application-pro.properties` nếu là môi trường thât, `application-dev.properties` nếu là môi trường test:

   server.port=${port:đầu port}
   spring.datasource.url=đường dẫn cơ sở dữ liệu
   spring.datasource.username= tên người dùng
   spring.datasource.password= mật khẩu
   spring.datasource.driver-class-name=loại driver của cơ sở dữ liệu

   local.lang.path= đường dẫn đến file ngôn ngữ.


## Sử Dụng
Chạy ứng dụng Spring Boot:

```bash
java -jar target/reward_management-1.0.0-SNAPSHOT.jar