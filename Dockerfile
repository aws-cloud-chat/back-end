# ============================
# Build Stage
# ============================
FROM gradle:8.7-jdk21-alpine AS builder
WORKDIR /app

# Gradle 캐싱을 위해 필요한 파일만 먼저 복사
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# 의존성 캐싱
RUN gradle dependencies --no-daemon || true

# 이후 전체 프로젝트 복사
COPY . .

# 테스트 제외하고 빌드 (CI/CD 환경 고려)
RUN gradle clean build -x test --no-daemon


# ============================
# Run Stage
# ============================
FROM bellsoft/liberica-openjdk-alpine:21
WORKDIR /app

# 필수 패키지 설치 + 타임존 세팅
RUN apk update && \
    apk add --no-cache tzdata ca-certificates && \
    cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime && \
    echo "Asia/Seoul" > /etc/timezone && \
    apk del tzdata

# JVM 임시 폴더 (upload, temp cache 안정성)
RUN mkdir -p /app/tmp
ENV JAVA_TOOL_OPTIONS="-Djava.io.tmpdir=/app/tmp"

# 빌드된 jar 복사
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

# JVM timezone 설정 + 실행
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]
