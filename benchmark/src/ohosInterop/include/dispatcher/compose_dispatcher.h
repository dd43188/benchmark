//
// Created by krauschen on 2024/3/16.
//
// Node APIs are not fully supported. To solve the compilation error of the interface cannot be found,
// please include "napi/native_api.h".

#ifndef SKIKOBRIDGE_COMPOSE_DISPATCHER_H
#define SKIKOBRIDGE_COMPOSE_DISPATCHER_H

#include "js_native_api.h"

typedef void (*skikobridge_async_vsync_callback)(long long timestamp, void *dataContext);
typedef void (*skikobridge_async_callback)(void *data);

extern napi_env skikobridge_get_current_napi_env();

/* 一段时间后将任务回抛到 JS 线程进行执行 after 是毫秒 */
extern void skikobridge_compose_coroutines_dispatcher_async_task(float after, void *data, skikobridge_async_callback callBack);

/* 请求一帧 Vsync 信号，回调是在 JS 线程 */
extern void skikobridge_compose_request_vsync_frame(void *dataContext, skikobridge_async_vsync_callback callBack);

extern void skikobridge_performance_trace_start(long taskKind, long taskId);

extern void skikobridge_performance_trace_end(long taskKind, long taskId);

/* 获取屏幕像素密度的 API */
extern float skikobridge_compose_get_screen_density();

/* LogI */
extern void skikobridge_compose_logI(const char *log);

/* LogE */
extern void skikobridge_compose_logE(const char *log);

/* LogW */
extern void skikobridge_compose_logW(const char *log);

/* LogD */
extern void skikobridge_compose_logD(const char *log);

/* 通知 egl 进行事务提交 */
extern void com_tencent_tmm_compose_elg_finish_draw();

#endif //SKIKOBRIDGE_COMPOSE_DISPATCHER_H
