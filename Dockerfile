# ============================
# Build Stage
# ============================
FROM gradle:8.7-jdk21-alpine AS builder
WORKDIR /app

# 캐싱 최적화를 위해 먼저 gradle 파일만 복사
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# 의존성 캐싱
RUN gradle dependencies --no-daemon || return 0

# 이후 전체 소스 복사
COPY . .

RUN gradle clean build -x test --no-daemon


# ============================
# Run Stage
# ============================
FROM bellsoft/liberica-openjdk-alpine:21
WORKDIR /app

RUN apk update && apk add --no-cache ca-certificates

# tmp 디렉토리 설정
RUN mkdir -p /app/tmp
ENV JAVA_TOOL_OPTIONS="-Djava.io.tmpdir=/app/tmp"

# 빌드 산출물 복사
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

# JVM 타임존 설정 추가
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]