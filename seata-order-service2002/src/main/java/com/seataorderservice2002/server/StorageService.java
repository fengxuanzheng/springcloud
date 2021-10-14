package com.seataorderservice2002.server;

public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
