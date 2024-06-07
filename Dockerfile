# JDK 17을 포함한 OpenJDK 이미지를 베이스 이미지로 사용
FROM openjdk:17-jdk-slim

# 필수 패키지 설치
RUN apt-get update && apt-get install -y wget curl unzip

# 작업 디렉토리를 설정합니다.
WORKDIR /app

# 스프링 애플리케이션 JAR 파일을 컨테이너로 복사합니다.
COPY ./build/libs/notify-email-sender-0.0.1-SNAPSHOT.jar /app/notify-email-sender.jar

# 포트를 엽니다.
EXPOSE 8083

# 어플리케이션을 실행합니다.
ENTRYPOINT ["java", "-jar", "/app/notify-email-sender.jar"]
