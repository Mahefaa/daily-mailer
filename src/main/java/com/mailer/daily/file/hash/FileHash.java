package com.mailer.daily.file.hash;

import com.mailer.daily.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
